package it.unibo.game.app.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import it.unibo.game.Pair;
import it.unibo.game.app.api.BoundingBox;

/**
 * Class that builds a boundig box around a GameObject to control collisions.
 */
public class AbstractBoundingBox implements BoundingBox {

  private Map<Corner, Pair<Double, Double>> corners = new HashMap<>();

  /**
   * 
   * @param w   GameObject width
   * @param h   GameObject height
   * @param pos GameObject position
   */
  public AbstractBoundingBox(final Double w, final Double h,
      final Pair<Double, Double> pos) {
    this.corners.put(Corner.LEFT_DOWN,
        new Pair<Double, Double>(pos.getX(), pos.getY() + h));
    this.corners.put(Corner.LEFT_UP, pos);
    this.corners.put(Corner.RIGHT_DOWN,
        new Pair<Double, Double>(pos.getX() + w, pos.getY() + h));
    this.corners.put(Corner.RIGHT_UP,
        new Pair<Double, Double>(pos.getX() + w, pos.getY()));

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Optional<Side> collideWith(final BoundingBox b) {
    if ((this.equals(this.corners.get(Corner.LEFT_DOWN).getY(),
        b.getBox().get(Corner.LEFT_UP).getY())
        || this.equals(this.corners.get(Corner.LEFT_UP).getY(),
            b.getBox().get(Corner.LEFT_DOWN).getY()))
        && (this.corners.get(Corner.LEFT_UP).getX() <= b.getBox().get(Corner.RIGHT_DOWN)
            .getX()
            && this.corners.get(Corner.RIGHT_UP).getX() >= b.getBox()
                .get(Corner.LEFT_DOWN).getX())) {
      return Optional.of(Side.UP_DOWN);

    } else if ((this.equals(this.corners.get(Corner.RIGHT_DOWN).getX(),
        b.getBox().get(Corner.LEFT_DOWN).getX())
        || this.equals(this.corners.get(Corner.LEFT_DOWN).getX(),
            b.getBox().get(Corner.RIGHT_DOWN).getX()))
        && (this.corners.get(Corner.RIGHT_DOWN).getY() >= b.getBox().get(Corner.LEFT_UP)
            .getY()
            && this.corners.get(Corner.RIGHT_UP).getY() <= b.getBox()
                .get(Corner.LEFT_DOWN).getY())) {
      return Optional.of(Side.LEFT_RIGHT);
    }

    return Optional.empty();
  }

  /**
   * 
   * @param d1
   * @param d2
   * @return Returns true if d1 is within the range.
   */
  private boolean equals(final Double d1, final Double d2) {
    return (d1 >= d2 - 2 && d1 <= d2 + 2);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Map<Corner, Pair<Double, Double>> getBox() {
    return this.corners;
  }

}
