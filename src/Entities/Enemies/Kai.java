package Entities.Enemies;

import Entities.Common.AttackPower;
import Entities.Common.Defense;
import Entities.Common.Health;

public class Kai extends Enemy {
    // Ultra-high health, ultra-high attack, has a special skill that can instantly kill the player.
    public Kai() {
        super(new Health(3000), new AttackPower(300, 500), new Defense(20));
        this.name = "Kai";
        this.dodge = 0.3; // 30% chance to dodge attacks
    }
}