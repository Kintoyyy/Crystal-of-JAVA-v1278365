package Entities.Characters;

import Animations.Animation;
import Animations.Entities.EntityAnimation;
import Animations.Frames;
import Animations.enums.DIRECTION;
import Animations.enums.TYPE;
import Entities.Common.AttackPower;
import Entities.Common.Defense;
import Entities.Common.Health;
import Entities.Common.Mana;
import Battle.Skills.*;
import Battle.Skills.Archer.*;
import Utils.SpriteSheet;
import Utils.ImageUtils;

import java.util.ArrayList;

public class Nathan extends Character {
    public Nathan() {
        // Pass all parameters, including playerSheet, to the superclass constructor
        super("Nathan", 1, new Health(900), new Mana(120), new AttackPower(140), new Defense(15), new ArrayList<>());

        this.addSkill(new Archer());
        this.addSkill(new PrecisionShot());
        this.addSkill(new MultiShot());
        this.addSkill(new PoisonArrow());
//        this.addSkill(new Evasion());

        SpriteSheet profile = new SpriteSheet(ImageUtils.loadImage("/Player/Nathan/Profile.png"));
        this.profileImage = profile.crop(0, 0, 300, 300);

        Frames sheet = new Frames(ImageUtils.loadImage("/Player/Nathan/Character.png"), 32, 32);

        animation = new Animation(sheet)
                .setDefaultAnimation(sheet.extractFrames(0, 0, 6, 1))
                .addAnimation(TYPE.IDLE, DIRECTION.DOWN, sheet.extractFrames(0, 0, 6, 1))
                .addAnimation(TYPE.IDLE, DIRECTION.LEFT, sheet.extractFrames(0, 1, 6, 2, true))
                .addAnimation(TYPE.IDLE, DIRECTION.RIGHT, sheet.extractFrames(0, 1, 6, 2))
                .addAnimation(TYPE.IDLE, DIRECTION.UP, sheet.extractFrames(0, 2, 6, 3))
                .addAnimation(TYPE.WALK, DIRECTION.DOWN, sheet.extractFrames(0, 3, 6, 4))
                .addAnimation(TYPE.WALK, DIRECTION.LEFT, sheet.extractFrames(0, 4, 6, 5, true))
                .addAnimation(TYPE.WALK, DIRECTION.RIGHT, sheet.extractFrames(0, 4, 6, 5))
                .addAnimation(TYPE.WALK, DIRECTION.UP, sheet.extractFrames(0, 5, 6, 6))
                .addAnimation(TYPE.SLEEP, DIRECTION.LEFT, sheet.extractFrames(0, 6, 5, 7, true))
                .addAnimation(TYPE.SLEEP, DIRECTION.RIGHT, sheet.extractFrames(0, 6, 5, 7))
                .addAnimation(TYPE.GHOST, DIRECTION.DOWN, sheet.extractFrames(0, 7, 4, 8))
                .addAnimation(TYPE.GHOST, DIRECTION.LEFT, sheet.extractFrames(0, 8, 4, 9, true))
                .addAnimation(TYPE.GHOST, DIRECTION.RIGHT, sheet.extractFrames(0, 8, 4, 9))
                .addAnimation(TYPE.GHOST, DIRECTION.UP, sheet.extractFrames(0, 9, 4, 10))
                .addAnimation(TYPE.TIRED, DIRECTION.DOWN, sheet.extractFrames(0, 11, 6, 12))
                .addAnimation(TYPE.TIRED, DIRECTION.LEFT, sheet.extractFrames(0, 12, 6, 13, true))
                .addAnimation(TYPE.TIRED, DIRECTION.RIGHT, sheet.extractFrames(0, 12, 6, 13))
                .addAnimation(TYPE.DANCE, sheet.extractFrames(0, 12, 8, 13))
                .addAnimation(TYPE.DEAD, sheet.extractFrame(3, 6));
    }

    @Override
    public void useSkill(int index) {
        if (index >= 0 && index < skills.size()) {
            Skill skill = skills.get(index);
            // Logic for using the skill can go here
        }
    }

    @Override
    public void useSkill(Skill skill) {
        // Logic for using a specific skill can go here
    }
}
