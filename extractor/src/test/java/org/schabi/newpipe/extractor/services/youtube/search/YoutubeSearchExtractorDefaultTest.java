package org.schabi.newpipe.extractor.services.youtube.search;

import org.junit.BeforeClass;
import org.junit.Test;
import org.schabi.newpipe.Downloader;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.channel.ChannelInfoItem;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeSearchExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;
import org.schabi.newpipe.extractor.utils.Localization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.schabi.newpipe.extractor.ServiceList.YouTube;

/*
 * Created by Christian Schabesberger on 27.05.18
 *
 * Copyright (C) Christian Schabesberger 2018 <chris.schabesberger@mailbox.org>
 * YoutubeSearchExtractorStreamTest.java is part of NewPipe.
 *
 * NewPipe is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * NewPipe is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with NewPipe.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * Test for {@link YoutubeSearchExtractor}
 */
public class YoutubeSearchExtractorDefaultTest extends YoutubeSearchExtractorBaseTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
        NewPipe.init(Downloader.getInstance(), new Localization("GB", "en"));
        extractor = (YoutubeSearchExtractor) YouTube.getSearchExtractor("pewdiepie");
        extractor.fetchPage();
        itemsPage = extractor.getInitialPage();
    }



    @Test
    public void testGetSecondPageUrl() throws Exception {
        assertEquals("https://www.youtube.com/results?q=pewdiepie&page=2&gl=GB", extractor.getNextPageUrl());
    }

    @Test
    public void testResultList_FirstElement() {
        InfoItem firstInfoItem = itemsPage.getItems().get(1);

        // THe channel should be the first item
        assertTrue(firstInfoItem instanceof ChannelInfoItem);
        assertEquals("name", "PewDiePie", firstInfoItem.getName());
        assertEquals("url","https://www.youtube.com/user/PewDiePie", firstInfoItem.getUrl());
    }

    @Test
    public void testResultListCheckIfContainsStreamItems() {
        boolean hasStreams = false;
        for(InfoItem item : itemsPage.getItems()) {
            if(item instanceof StreamInfoItem) {
                hasStreams = true;
            }
        }
        assertTrue("Has no InfoItemStreams", hasStreams);
    }

    @Test
    public void testGetSecondPage() throws Exception {
        YoutubeSearchExtractor secondExtractor =
                (YoutubeSearchExtractor) YouTube.getSearchExtractor("pewdiepie");
        ListExtractor.InfoItemsPage<InfoItem> secondPage = secondExtractor.getPage(itemsPage.getNextPageUrl());
        assertTrue(Integer.toString(secondPage.getItems().size()),
                secondPage.getItems().size() > 10);

        // check if its the same result
        boolean equals = true;
        for (int i = 0; i < secondPage.getItems().size()
                && i < itemsPage.getItems().size(); i++) {
            if(!secondPage.getItems().get(i).getUrl().equals(
                    itemsPage.getItems().get(i).getUrl())) {
                equals = false;
            }
        }
        assertFalse("First and second page are equal", equals);

        assertEquals("https://www.youtube.com/results?q=pewdiepie&page=3&gl=GB", secondPage.getNextPageUrl());
    }

    @Test
    public void testSuggestionNotNull() throws Exception {
        //todo write a real test
        assertTrue(extractor.getSearchSuggestion() != null);
    }


    @Test
    public void testId() throws Exception {
        assertEquals("pewdiepie", extractor.getId());
    }

    @Test
    public void testName() {
        assertEquals("pewdiepie", extractor.getName());
    }
}
