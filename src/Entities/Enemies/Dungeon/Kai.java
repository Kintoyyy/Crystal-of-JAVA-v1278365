package Entities.Enemies.Dungeon;

import Animations.Animation;
import Animations.Frames;
import Animations.enums.DIRECTION;
import Animations.enums.TYPE;
import Entities.Common.AttackPower;
import Entities.Common.Defense;
import Entities.Common.Health;
import Entities.Enemies.Enemy;
import Utils.ImageUtils;

public class Kai extends Enemy {

    // Ultra-high health, ultra-high attack, has a special skill that can instantly kill the selectedPlayer.
    public Kai() {
        super(new Health(3000), new AttackPower(300, 500), new Defense(20));
        this.name = "KAI";
        this.key = "KAI";
        this.dodge = 0.3; // 30% chance to dodge attacks

        Frames sheet = new Frames(ImageUtils.loadImage("/Maps/Dungeon/SirKhai_finalBoss.png"), 48, 48);

        setDialogLines(
                "You have encountered a Skeleton Boss!",
                "Prepare for battle!",
                "Defeat the Skeleton Boss to continue!",
                "Good luck!",
                "Skeleton Boss: I will defeat you!",
                "Skeleton Boss: You will never defeat me!"
        );


        animation = new Animation(sheet)
                .setDefaultAnimation(sheet.extractFrames(0, 0, 6, 1))
                .addAnimation(TYPE.IDLE, DIRECTION.DOWN, sheet.extractFrames(0, 0, 6, 1))
                .addAnimation(TYPE.IDLE, DIRECTION.LEFT, sheet.extractFrames(0, 1, 6, 2, true))
                .addAnimation(TYPE.IDLE, DIRECTION.RIGHT, sheet.extractFrames(0, 1, 6, 2))
                .addAnimation(TYPE.IDLE, DIRECTION.UP, sheet.extractFrames(0, 2, 6, 3))
                .addAnimation(TYPE.DEAD, sheet.extractFrame(3, 9));
    }
}
