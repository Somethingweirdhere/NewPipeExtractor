package org.schabi.newpipe.extractor.services.youtube.linkHandler;

/*
 * Created by Christian Schabesberger on 12.08.17.
 *
 * Copyright (C) Christian Schabesberger 2018 <chris.schabesberger@mailbox.org>
 * YoutubeTrendingLinkHandlerFactory.java is part of NewPipe.
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

import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;
import org.schabi.newpipe.extractor.utils.Parser;

import java.util.List;

public class YoutubeTrendingLinkHandlerFactory extends ListLinkHandlerFactory {

    public String getUrl(String id, List<String> contentFilters, String sortFilter) {
        switch(id) {
            case "Trending": return "https://www.youtube.com/feed/trending";
            case "Music": return "https://bit.ly/2CCie5E";
            case "Live": return "https://bit.ly/2OKDQE9";
            case "Gaming": return "https://bit.ly/2R9m4Hm";
            case "Movies": return "https://bit.ly/2AqjBCN";
            case "News": return "https://bit.ly/2D4bkat";
            default: return null;
        }
    }

    @Override
    public String getId(String url) {
        switch (url) {
            case "https://bit.ly/2CCie5E": return "Music";
            case "https://bit.ly/2OKDQE9": return "Live";
            case "https://bit.ly/2R9m4Hm": return "Gaming";
            case "https://bit.ly/2AqjBCN": return "Movies";
            case "https://bit.ly/2D4bkat": return "News";
            default: return "Trending";
        }
    }

    @Override
    public boolean onAcceptUrl(final String url) {
        //return Parser.isMatch("^(https://|http://|)(www.|m.|)youtube.com/feed/trending(|\\?.*)$", url);
        return true;
    }
}
