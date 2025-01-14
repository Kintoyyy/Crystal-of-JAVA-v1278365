package Components.Card;

import Entities.Characters.Character;
import Game.Handler;
import Utils.ImageUtils;
import Utils.SpriteSheet;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class CharacterCard extends Card {
    private Character player;
    private BufferedImage playerProfile;
    private final BufferedImage frame;
    private final BufferedImage healthBar;
    private final BufferedImage manaBar;
    private double health;
    private double mana;
    private final Handler handler;

    public CharacterCard(Handler handler) {
        super();
        this.handler = handler;

        this.width = 48;
        this.height = 19;

        // Initialize sprite sheet and UI components
        SpriteSheet sheet = new SpriteSheet(ImageUtils.loadImage("/ui/Game_UI.png"));
        frame = sheet.crop(155, 0, 48, 19);
        healthBar = sheet.crop(144, 0, 10, 5);
        manaBar = sheet.crop(144, 5, 10, 5);
    }

    @Override
    public void tick() {
        super.tick();

        player = handler.getCharacterManager().getPlayer();
        if (player != null) {
            playerProfile = player.getProfile();
            health = player.getHealth().getHealth();
            mana = player.getMana().getMana();
        }
    }

    @Override
    public void render(Graphics g) {
        // Background and profile image rendering
        g.setColor(new Color(24, 20, 37));
        g.fillRect(this.x + 10, this.y + 10, height - 20, height - 20);
        g.fillRect(this.x + (20 * scale), this.y + (4 * scale), 162, 10 * scale);

        if (playerProfile != null) {
            g.drawImage(playerProfile, this.x + 12, this.y + 12, height - 26, height - 26, null);
        }

        if (player != null) {
            renderHealthManaBars(g);
        }

        // Frame rendering
        g.drawImage(frame, this.x, this.y, width, height, null);


    }

    private void renderHealthManaBars(Graphics g) {
        double maxHealth = player.getHealth().getBaseHealth();
        double maxMana = player.getMana().getBaseMana();

        // Calculate the width for health and mana bars
        int healthWidth = (int) ((health / maxHealth) * (27 * scale));
        int manaWidth = (int) ((mana / maxMana) * (27 * scale));

        // Draw health and mana bars
        g.drawImage(healthBar, this.x + (20 * scale), this.y + (4 * scale), healthWidth, 5 * scale, null);
        g.drawImage(manaBar, this.x + (20 * scale), this.y + (9 * scale), manaWidth, 5 * scale, null);
    }

    @Override
    public void onClick(MouseEvent e) {
        // No action implemented for clicks in this menu
    }
}
