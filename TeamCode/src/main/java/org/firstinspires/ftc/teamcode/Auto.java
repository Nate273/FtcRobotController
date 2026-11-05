package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Auto extends LinearOpMode {
    double ticksperInch = 537.7 * 19.2 / 326.73;
    public double ticksperDegree = 537.7 * 19.2 / 360;
    public Hardware robot;

    // when you press init
    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Hardware(hardwareMap);

        waitForStart();


        forwardencoderversion(0.2, 59);
        sleep(6500);
    }

    public void forwardencoderversion(double power, double inches) {
        robot.left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int ticks = (int) (inches * ticksperInch);

        robot.left.setTargetPosition(ticks);
        robot.right.setTargetPosition(ticks);
        robot.leftBack.setTargetPosition(ticks);
        robot.rightBack.setTargetPosition(ticks);

        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.left.setPower(power);
        robot.right.setPower(power);
    }

    public void turnencoderversion(double power, double inches) {
        robot.left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int ticks = (int) (inches * ticksperDegree);

        robot.left.setTargetPosition(ticks);
        robot.right.setTargetPosition(-ticks);
        robot.rightBack.setTargetPosition(-ticks);
        robot.leftBack.setTargetPosition(ticks);

        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.left.setPower(power);
        robot.right.setPower(power);
    }
}