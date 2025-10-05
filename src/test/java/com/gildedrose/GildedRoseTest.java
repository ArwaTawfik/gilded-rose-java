package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    String agedBrie = "Aged Brie";
    String sulfuras="Sulfuras, Hand of Ragnaros";
    String backstagePasses="Backstage passes to a TAFKAL80ETC concert";
    @Test
    void qualityDecreaseDaily() {
        Item[] items = new Item[] { new Item("Cheese", 4, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void qualityDecreaseTwiceAsFast() {
        Item[] items = new Item[] { new Item("Cheese", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void qualityNoDecreaseAfterZero() {
        Item[] items = new Item[] { new Item("Cheese", 4, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void qualityIncreaseIfAgedBrie() {
        Item[] items = new Item[] { new Item(agedBrie, 1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void qualityLessThanFifty() {
        Item[] items = new Item[] { new Item(agedBrie, 1, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void qualityRemainsIfSulfuras() {
        Item[] items = new Item[] { new Item(sulfuras, 5, 80) ,
                new Item(sulfuras, 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void qualityIncreaseIfBackstagePassess() {
        Item[] items = new Item[]{new Item(backstagePasses, 6, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(32, app.items[0].quality);
        app.updateQuality();
        assertEquals(35, app.items[0].quality);
    }

    @Test
    void qualityDropsToZeroIfBackstagePassesAndLastDay() {
        Item[] items = new Item[]{ new Item(backstagePasses, 0, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

}
