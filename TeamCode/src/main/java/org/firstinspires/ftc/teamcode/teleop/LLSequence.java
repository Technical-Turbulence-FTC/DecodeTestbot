//package org.firstinspires.ftc.teamcode.teleop;
//
//import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.limelightvision.limelight3.Limelight3A;
//import com.limelightvision.limelight3.LLResult;
//import com.limelightvision.limelight3.FiducialResult;
//
//import java.util.*;
//
//@TeleOp(name = "LL Sequence")
//public class LLSequence extends OpMode {
//
//    private Limelight3A limelight;
//
//    @Override
//    public void init() {
//        limelight = hardwareMap.get(Limelight3A.class, "limelight");
//        limelight.setPollRateHz(100);
//        limelight.pipelineSwitch(1);
//        limelight.start();
//    }
//
//    @Override
//    public void loop() {
//
//        LLResult result = limelight.getLatestResult();
//
//        if (result == null || !result.isValid()) {
//            telemetry.addLine("No tag found.");
//            return;
//        }
//
//        List<FiducialResult> fiducials = result.getFiducialResults();
//
//        if (fiducials == null || fiducials.isEmpty()) {
//            telemetry.addLine("No tag found.");
//            return;
//        }
//
//        String[] sequence = {}
//        for (FiducialResult fiducial : fiducials) {
//            int id = fiducial.getFiducialId();
//            if (id == 21) {
//                sequence = {"G", "P", "P"};
//            }
//            else if (id == 22) {
//                sequence = {"P", "G", "P"};
//            }
//            else if (id == 23) {
//                sequence = {"P", "P", "G"};
//            }
//            telemetry.addData("Sequence", sequence);
//        }
//    }
//}
//
