package org.openmaptiles.layers;

import com.onthegomap.planetiler.FeatureCollector;
import com.onthegomap.planetiler.config.PlanetilerConfig;
import com.onthegomap.planetiler.stats.Stats;
import com.onthegomap.planetiler.util.Translations;
import org.openmaptiles.generated.OpenMapTilesSchema;
import org.openmaptiles.generated.Tables;

public class Tree implements
  OpenMapTilesSchema.Tree,
  Tables.OsmTree.Handler {

  public Tree(Translations translations, PlanetilerConfig config, Stats stats) {}

  private static final String LAYER_NAME = "tree";

  @Override
  public String name() {
    return LAYER_NAME;
  }

  @Override
  public void process(Tables.OsmTree element, FeatureCollector features) {
    features.point(LAYER_NAME)
      .setBufferPixels(4)
      .setMinZoom(14)
      .setAttr("leaf_type", element.source().getTag("leaf_type"));
  }
}
