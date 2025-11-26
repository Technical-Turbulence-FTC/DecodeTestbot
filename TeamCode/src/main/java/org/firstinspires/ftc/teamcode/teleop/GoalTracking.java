package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.LLStatus;

import java.util.*;

@TeleOp(name = "Goal Tracking")
public class GoalTracking extends OpMode {

    private Limelight3A limelight;

    @Override
    public void init() {
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.setPollRateHz(100);
        limelight.pipelineSwitch(1);
        limelight.start();
    }


    public boolean isGoalVisible() {
        LLResult result = limelight.getLatestResult();
        return result != null && result.isValid();
    }

    public double getGoalX() {
        LLResult result = limelight.getLatestResult();
        if (result != null && result.isValid()) {
             List<LLResultTypes.FiducialResult> detections = result.getFiducialResults();
            if (!detections.isEmpty()) {
                return detections.get(0).getTargetXDegrees();
            }
        }
        return Double.NaN;
    }

    public double getGoalY() {
        LLResult result = limelight.getLatestResult();
        if (result != null && result.isValid()) {
            List<LLResultTypes.FiducialResult> detections = result.getFiducialResults();
            if (!detections.isEmpty()) {
                return detections.get(0).getTargetYDegrees();
            }
        }
        return Double.NaN; // if not found
    }
}