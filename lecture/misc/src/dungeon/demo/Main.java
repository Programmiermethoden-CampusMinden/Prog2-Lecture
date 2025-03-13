package demo;

import core.Entity;
import core.Game;
import core.components.*;
import core.configuration.KeyboardConfig;
import core.utils.components.path.SimpleIPath;
import java.io.IOException;

public class Main {
  public static void main(String... args) {

    // Add some one-time configuration
    Game.userOnSetup(
        () -> {
          Entity hero = new Entity();

          hero.add(new PositionComponent());

          try {
            hero.add(new DrawComponent(new SimpleIPath("character/knight")));
          } catch (IOException e) {
            System.err.println("Could not load textures for hero.");
            throw new RuntimeException(e);
          }

          hero.add(new CameraComponent());
          hero.add(new PlayerComponent());

          VelocityComponent vc = new VelocityComponent(5f, 5f);
          hero.add(vc);
          vc.currentXVelocity(10f);
          vc.previousXVelocity(10f);

          PlayerComponent pc = new PlayerComponent();
          pc.registerCallback(
              KeyboardConfig.MOVEMENT_UP.value(),
              entity -> {
                vc.currentYVelocity(vc.yVelocity());
              });
          pc.registerCallback(
              KeyboardConfig.MOVEMENT_DOWN.value(), entity -> vc.currentYVelocity(-vc.yVelocity()));
          pc.registerCallback(
              KeyboardConfig.MOVEMENT_LEFT.value(), entity -> vc.currentXVelocity(-vc.xVelocity()));
          pc.registerCallback(
              KeyboardConfig.MOVEMENT_RIGHT.value(), entity -> vc.currentXVelocity(vc.xVelocity()));
          hero.add(pc);

          pc.registerCallback(
              KeyboardConfig.FIRST_SKILL.value(),
              entity -> {
                Entity fb = new Entity("Fireball");

                fb.add(
                    new PositionComponent(entity.fetch(PositionComponent.class).get().position()));

                try {
                  fb.add(new DrawComponent(new SimpleIPath("character/knight")));
                } catch (IOException e) {
                  System.err.println("Could not load textures for fireball.");
                  throw new RuntimeException(e);
                }

                fb.add(new VelocityComponent(2f, 2f));

                fb.add(new WalkerComponent());

                Game.add(fb);
              },
              false);

          Game.add(hero);
        });

    // Create a new monster in every new level
    Game.userOnLevelLoad(
        first -> {
          Entity fb = new Entity("HUGO");

          fb.add(
              new PositionComponent(
                  Game.hero().get().fetch(PositionComponent.class).get().position()));

          try {
            fb.add(new DrawComponent(new SimpleIPath("character/knight")));
          } catch (IOException e) {
            System.err.println("Could not load textures for fireball.");
            throw new RuntimeException(e);
          }

          VelocityComponent vc = new VelocityComponent(10f, 10f);
          vc.currentYVelocity(vc.yVelocity());
          fb.add(vc);

          fb.add(new WalkerComponent());

          Game.add(fb);
        });

    // Register our new system
    Game.add(new WalkerSystem());

    // Start the game loop
    Game.run();
  }
}
