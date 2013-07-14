/**
 * (C)opyright 2013, by Object Refinery Limited
 */
package org.jfree.chart3d.plot;

import org.jfree.graphics3d.World;

/**
 * A plot for a 3D chart.  Implementations will include {@link PiePlot3D},
 * CategoryPlot3D and XYZPlot.
 */
public interface Plot3D {

  /**
   * Adds 3D objects representing the current data for the plot to the specified
   * world.  After the world has been populated (or constructed) in this way,
   * it is ready for rendering.
   * 
   * @param world  the world (<code>null</code> not permitted).
   * @param xOffset  the x-offset.
   * @param yOffset  the y-offset.
   * @param zOffset  the z-offset.
   */
  public void composeToWorld(World world, double xOffset, double yOffset, 
          double zOffset);

}
