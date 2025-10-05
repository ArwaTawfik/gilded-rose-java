package com.gildedrose;

class GildedRose {
    Item[] items;

    String SULFURAS = "Sulfuras, Hand of Ragnaros";
    String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    String AGED_BRIE = "Aged Brie";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQualitybyValue(Item item, int value) {
        item.quality += value;
        if (item.quality > 50) {
            item.quality = 50;
        }
        if (item.quality < 0) {
            item.quality = 0;
        }
    }

    public void increaseQuality(Item item) {
        if (item.sellIn <= 0) {
            updateQualitybyValue(item, 2);
        } else {
            updateQualitybyValue(item, 1);
        }
    }

    public void decreaseQuality(Item item) {
        if (item.sellIn <= 0) {
            updateQualitybyValue(item, -2);
        } else {
            updateQualitybyValue(item, -1);
        }
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {

            if(items[i].name.equals(SULFURAS)) {
                continue;
            }

            items[i].sellIn = items[i].sellIn - 1;

            if (items[i].name.equals(BACKSTAGE_PASSES)) {
                if (items[i].sellIn < 11) {
                    updateQualitybyValue(items[i], 2);
                }
                if (items[i].sellIn < 6) {
                    updateQualitybyValue(items[i], 3);
                }
                if (items[i].sellIn <= 0) {
                    updateQualitybyValue(items[i], -1*items[i].quality);
                }
                continue;
            }

            if(items[i].name.equals(AGED_BRIE)) {
                increaseQuality(items[i]);
                continue;
            }

            decreaseQuality(items[i]);
        }
    }
}