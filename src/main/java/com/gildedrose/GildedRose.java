package com.gildedrose;

class GildedRose {
    Item[] items;

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

    public void decreaseQuality(Item item, int degradationScale) {
        if (item.sellIn <= 0) {
            updateQualitybyValue(item, -2 * degradationScale);
        } else {
            updateQualitybyValue(item, -1 * degradationScale);
        }
    }

    public void backstagePasses(Item item) {
        if (item.sellIn <= 0) {
            updateQualitybyValue(item, -1 * item.quality);
        } else if (item.sellIn < 6) {
            updateQualitybyValue(item, 3);
        } else if (item.sellIn < 11) {
            updateQualitybyValue(item, 2);
        }
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            switch (items[i].name) {
                case "Sulfuras, Hand of Ragnaros":
                    continue;
                case "Backstage passes to a TAFKAL80ETC concert":
                    backstagePasses(items[i]);
                    break;
                case "Aged Brie":
                    increaseQuality(items[i]);
                    break;
                case "Conjured":
                    decreaseQuality(items[i], 2);
                    break;
                default:
                    decreaseQuality(items[i], 1);
            }
            items[i].sellIn--;
        }
    }
}