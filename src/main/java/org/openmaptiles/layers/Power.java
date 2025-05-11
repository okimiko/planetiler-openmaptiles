package org.openmaptiles.layers;

import com.onthegomap.planetiler.FeatureCollector;
import com.onthegomap.planetiler.config.PlanetilerConfig;
import com.onthegomap.planetiler.stats.Stats;
import com.onthegomap.planetiler.util.Translations;
import org.openmaptiles.generated.OpenMapTilesSchema;
import org.openmaptiles.generated.Tables;

public class Power implements
  OpenMapTilesSchema.Power,
  Tables.OsmPowerPoint.Handler,
  Tables.OsmPowerLine.Handler, 
  Tables.OsmPowerPolygon.Handler {

    public Power(Translations translations, PlanetilerConfig config, Stats stats) {}
    private static final String LAYER_NAME = "power";

    @Override
    public String name() {
      return LAYER_NAME;
    }

    @Override
    public void process(Tables.OsmPowerPoint element, FeatureCollector features) {
      features.point(LAYER_NAME)
        .setBufferPixels(BUFFER_SIZE)
        .setMinZoom(12)
        .setAttr("name", element.source().getTag("name"))
        .setAttr("class", element.source().getTag("power"))
        .setAttr("source_gen", element.source().getTag("plant:source"))
        .setAttr("method", element.source().getTag("plant:method"));
    }

    @Override
    public void process(Tables.OsmPowerLine element, FeatureCollector features) {
      features.line(LAYER_NAME)
        .setBufferPixels(BUFFER_SIZE)
        .setMinZoom(12)
        .setAttr("name", element.source().getTag("name"))
        .setAttr("class", element.source().getTag("power"));
    }

    @Override
    public void process(Tables.OsmPowerPolygon element, FeatureCollector features) {
      features.polygon(LAYER_NAME)
        .setBufferPixels(BUFFER_SIZE)
        .setMinZoom(13)
        .setAttr("name", element.source().getTag("name"))
        .setAttr("class", element.source().getTag("power"))
        .setAttr("source_gen", element.source().getTag("plant:source"))
        .setAttr("method", element.source().getTag("plant:method"));
    }
  }
