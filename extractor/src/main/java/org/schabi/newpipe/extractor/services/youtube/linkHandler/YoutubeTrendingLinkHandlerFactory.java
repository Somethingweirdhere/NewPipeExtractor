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
            case "Trending": return "crash";
            case "Music": return "https://www.youtube.com/feed/trending?bp=4gIuCggvbS8wNHJsZhIiUExGZ3F1TG5MNTlhbUxKTVppZ1N5TFpsUmV2UUhlcVBsaA%3D%3D";
            case "Live": return "https://www.youtube.com/feed/trending?bp=4gIuCggvbS8wNzM1bBIiUExVMTJ1SVR4QkVQRmtKRFdtYUs5QUV1aVNEUk1OeXdzQw%3D%3D";
            case "Gaming": return "https://www.youtube.com/feed/trending?bp=4gIvCgkvbS8wYnp2bTISIlBMaUN2Vkp6QnVwS2xGWkJHOXVVdUJUY1pJYmE2TnlzeXc%3D";
            case "Movies": return "https://www.youtube.com/feed/trending?bp=4gIuCggvbS8wMnZ4bhIiUExuUzZNOHZRRmtkSjlWT1JPbVd5bmFxVnhvcnlRV3dlSg%3D%3D";
            case "News": return "https://www.youtube.com/feed/trending?bp=4gIuCggvbS8wNWpoZxIiUEwzWlE1Q3BOdWxRa2lqaUkwSWxMc0I0R3NQWjhUNVlDZA%3D%3D";
            default: return null;
        }
    }

    @Override
    public String getId(String url) {
        return "Movies";
    }

    @Override
    public boolean onAcceptUrl(final String url) {
        //return Parser.isMatch("^(https://|http://|)(www.|m.|)youtube.com/feed/trending(|\\?.*)$", url);
        return true;
    }
}
