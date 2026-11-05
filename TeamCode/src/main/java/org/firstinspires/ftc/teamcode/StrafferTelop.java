package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Telop for Straffer")
public class StrafferTelop extends LinearOpMode{
    public Hardware robot;
    @Override
    // when you press init
    public void runOpMode() {
        robot = new Hardware(hardwareMap);
        robot.lift.setPosition(0);
        robot.push.setPosition(0);
        waitForStart();

        while (opModeIsActive()) {

            double drive = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x * 1.1;
            double turn = gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(drive) + Math.abs(strafe) + Math.abs(turn), 1);

            double leftPower = (drive + strafe + turn) / denominator;
            double backLeftPower = (drive - strafe + turn) / denominator;
            double rightPower = (drive - strafe - turn) / denominator;
            double backRightPower = (drive + strafe - turn) / denominator;

            robot.left.setPower(gamepad1.right_bumper ? leftPower * 0.5 : leftPower);
            robot.right.setPower(gamepad1.right_bumper ? rightPower * 0.5 : rightPower);
            robot.rightBack.setPower(gamepad1.right_bumper ? backRightPower * 0.5 : backRightPower);
            robot.leftBack.setPower(gamepad1.right_bumper ? backLeftPower * 0.5 : backLeftPower);

            if (gamepad2.left_trigger > .5) {
                robot.intake.setPower(1);
            } else {
                robot.intake.setPower(0);
            }
            if (gamepad2.triangle) {
                robot.lift.setPosition(-0.5);
                robot.push.setPosition(0);
            } else {
                robot.lift.setPosition(0);
            }
            if (gamepad2.x) {
                robot.lift.setPosition(-0.98);
                robot.push.setPosition(-0.5);
            }
            if (gamepad2.right_trigger > .5) {
                robot.shooter.setVelocity(-203);
                robot.push.setPosition(-0.98);
            }else{
                robot.shooter.setVelocity(0);
            }
        }
    }
}
