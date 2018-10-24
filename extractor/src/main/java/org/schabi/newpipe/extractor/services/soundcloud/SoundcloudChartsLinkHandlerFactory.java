package org.schabi.newpipe.extractor.services.soundcloud;

import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;
import org.schabi.newpipe.extractor.utils.Parser;

import java.util.List;

public class SoundcloudChartsLinkHandlerFactory extends ListLinkHandlerFactory {

    @Override
    public String getId(String url) {
        if (Parser.isMatch("^https?://(www\\.|m\\.)?soundcloud.com/charts(/top)?/?([#?].*)?$", url.toLowerCase())) {
            return "Top 50";
        } else {
            return "New & hot";
        }
    }

    @Override
    public String getUrl(String id, List<String> contentFilter, String sortFilter) {
        switch(id) {
            case "Top 50": return "https://soundcloud.com/charts/top";
            case "New & hot": return "https://soundcloud.com/charts/new";
            default: return null;
        }
    }

    @Override
    public boolean onAcceptUrl(final String url) {
        return Parser.isMatch("^https?://(www\\.|m\\.)?soundcloud.com/charts(/top|/new)?/?([#?].*)?$", url);
    }
}
