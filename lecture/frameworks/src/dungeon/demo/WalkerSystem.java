package demo;

import core.System;
import core.components.VelocityComponent;

public class WalkerSystem extends System {
  public WalkerSystem() {
    super(WalkerComponent.class);
  }

  @Override
  public void execute() {
    entityStream()
        .forEach(
            e -> {
              if (e.isPresent(WalkerComponent.class)) {
                VelocityComponent vc = e.fetch(VelocityComponent.class).get();
                vc.currentXVelocity(vc.xVelocity());
                vc.currentYVelocity(vc.yVelocity());
              }
            });
  }
}
