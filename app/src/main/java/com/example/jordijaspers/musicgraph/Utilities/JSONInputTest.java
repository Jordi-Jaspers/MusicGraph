package com.example.jordijaspers.musicgraph.Utilities;

/**
 * This is one of the test JSON-files out of the given URL.
 */

public class JSONInputTest {

    private static final String JSONInput ="{\n" +
            "  \"results\": {\n" +
            "    \"opensearch:Query\": {\n" +
            "      \"#text\": \"\",\n" +
            "      \"role\": \"request\",\n" +
            "      \"searchTerms\": \"ed\",\n" +
            "      \"startPage\": \"1\"\n" +
            "    },\n" +
            "    \"opensearch:totalResults\": \"452964\",\n" +
            "    \"opensearch:startIndex\": \"0\",\n" +
            "    \"opensearch:itemsPerPage\": \"30\",\n" +
            "    \"artistmatches\": {\n" +
            "      \"artist\": [\n" +
            "        {\n" +
            "          \"name\": \"Ed Sheeran\",\n" +
            "          \"listeners\": \"1497257\",\n" +
            "          \"mbid\": \"b8a7c51f-362c-4dcb-a259-bc6e0095f0a6\",\n" +
            "          \"url\": \"https://www.last.fm/music/Ed+Sheeran\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/8b7b5dfd1ab9a226b99a3bdf8c4a8aa0.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/8b7b5dfd1ab9a226b99a3bdf8c4a8aa0.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/8b7b5dfd1ab9a226b99a3bdf8c4a8aa0.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/8b7b5dfd1ab9a226b99a3bdf8c4a8aa0.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/8b7b5dfd1ab9a226b99a3bdf8c4a8aa0.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Editors\",\n" +
            "          \"listeners\": \"1630872\",\n" +
            "          \"mbid\": \"0efe858c-89e5-4e47-906a-356fa953fd6e\",\n" +
            "          \"url\": \"https://www.last.fm/music/Editors\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/5ed3d80f739ded44e63413e79ddf77bf.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/5ed3d80f739ded44e63413e79ddf77bf.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/5ed3d80f739ded44e63413e79ddf77bf.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/5ed3d80f739ded44e63413e79ddf77bf.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/5ed3d80f739ded44e63413e79ddf77bf.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Eddie Vedder\",\n" +
            "          \"listeners\": \"950469\",\n" +
            "          \"mbid\": \"1a60d6dd-9d3e-40fc-a66d-3184f9ee0d61\",\n" +
            "          \"url\": \"https://www.last.fm/music/Eddie+Vedder\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/4ce9520ab6e94327b82ab4e5c886c548.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/4ce9520ab6e94327b82ab4e5c886c548.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/4ce9520ab6e94327b82ab4e5c886c548.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/4ce9520ab6e94327b82ab4e5c886c548.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/4ce9520ab6e94327b82ab4e5c886c548.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Edward Sharpe & The Magnetic Zeros\",\n" +
            "          \"listeners\": \"1111051\",\n" +
            "          \"mbid\": \"4a069029-4f64-4946-b650-01aeb0b55d9d\",\n" +
            "          \"url\": \"https://www.last.fm/music/Edward+Sharpe+&+The+Magnetic+Zeros\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/61ede677ef5e4c769e887ee0404df9d3.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/61ede677ef5e4c769e887ee0404df9d3.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/61ede677ef5e4c769e887ee0404df9d3.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/61ede677ef5e4c769e887ee0404df9d3.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/61ede677ef5e4c769e887ee0404df9d3.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Edguy\",\n" +
            "          \"listeners\": \"339005\",\n" +
            "          \"mbid\": \"83998f9c-846b-4294-aede-d7735531c901\",\n" +
            "          \"url\": \"https://www.last.fm/music/Edguy\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/9d7f6cecd8a04699a379784dedc9106c.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/9d7f6cecd8a04699a379784dedc9106c.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/9d7f6cecd8a04699a379784dedc9106c.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/9d7f6cecd8a04699a379784dedc9106c.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/9d7f6cecd8a04699a379784dedc9106c.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Eldo\",\n" +
            "          \"listeners\": \"82576\",\n" +
            "          \"mbid\": \"6c272ee4-ccb7-44b5-bf5d-ad7f6dbc32c5\",\n" +
            "          \"url\": \"https://www.last.fm/music/Eldo\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/2fb7b5e28ed64348915cc28ac9b9a7d8.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/2fb7b5e28ed64348915cc28ac9b9a7d8.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/2fb7b5e28ed64348915cc28ac9b9a7d8.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/2fb7b5e28ed64348915cc28ac9b9a7d8.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/2fb7b5e28ed64348915cc28ac9b9a7d8.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Édith Piaf\",\n" +
            "          \"listeners\": \"673439\",\n" +
            "          \"mbid\": \"4f8ef4a3-40fa-46b5-8773-97686a8424f4\",\n" +
            "          \"url\": \"https://www.last.fm/music/%C3%89dith+Piaf\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/e713eb81bdef415ab0f8e81c6f3ccf57.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/e713eb81bdef415ab0f8e81c6f3ccf57.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/e713eb81bdef415ab0f8e81c6f3ccf57.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/e713eb81bdef415ab0f8e81c6f3ccf57.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/e713eb81bdef415ab0f8e81c6f3ccf57.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Edvard Grieg\",\n" +
            "          \"listeners\": \"702077\",\n" +
            "          \"mbid\": \"013c8e5b-d72a-4cd3-8dee-6c64d6125823\",\n" +
            "          \"url\": \"https://www.last.fm/music/Edvard+Grieg\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/1b77113b3cf74dfdbb51ac95a99bfc87.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/1b77113b3cf74dfdbb51ac95a99bfc87.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/1b77113b3cf74dfdbb51ac95a99bfc87.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/1b77113b3cf74dfdbb51ac95a99bfc87.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/1b77113b3cf74dfdbb51ac95a99bfc87.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Edge of Sanity\",\n" +
            "          \"listeners\": \"68984\",\n" +
            "          \"mbid\": \"ce38e067-8e83-4660-8852-0c1db7ddaadb\",\n" +
            "          \"url\": \"https://www.last.fm/music/Edge+of+Sanity\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/7cb39744ae814d5d833b276c4f95a4e3.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/7cb39744ae814d5d833b276c4f95a4e3.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/7cb39744ae814d5d833b276c4f95a4e3.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/7cb39744ae814d5d833b276c4f95a4e3.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/7cb39744ae814d5d833b276c4f95a4e3.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Mt Eden\",\n" +
            "          \"listeners\": \"214097\",\n" +
            "          \"mbid\": \"3c87654e-324a-4d9e-b774-03a5115cd3b6\",\n" +
            "          \"url\": \"https://www.last.fm/music/Mt+Eden\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/15524da4c10343ec81925a5b8f3f6474.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/15524da4c10343ec81925a5b8f3f6474.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/15524da4c10343ec81925a5b8f3f6474.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/15524da4c10343ec81925a5b8f3f6474.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/15524da4c10343ec81925a5b8f3f6474.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Edyta Bartosiewicz\",\n" +
            "          \"listeners\": \"116926\",\n" +
            "          \"mbid\": \"9b851076-e896-4b90-9ffb-7f4c62ff39d7\",\n" +
            "          \"url\": \"https://www.last.fm/music/Edyta+Bartosiewicz\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/543cc49c2f104881c8b44530b3d904e0.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/543cc49c2f104881c8b44530b3d904e0.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/543cc49c2f104881c8b44530b3d904e0.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/543cc49c2f104881c8b44530b3d904e0.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/543cc49c2f104881c8b44530b3d904e0.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"edIT\",\n" +
            "          \"listeners\": \"181644\",\n" +
            "          \"mbid\": \"9b4aec00-c369-4707-807b-9229955ea3db\",\n" +
            "          \"url\": \"https://www.last.fm/music/edIT\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/269ede11b1a24f2585f6fa5a9fa1da6d.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/269ede11b1a24f2585f6fa5a9fa1da6d.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/269ede11b1a24f2585f6fa5a9fa1da6d.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/269ede11b1a24f2585f6fa5a9fa1da6d.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/269ede11b1a24f2585f6fa5a9fa1da6d.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Edenbridge\",\n" +
            "          \"listeners\": \"190378\",\n" +
            "          \"mbid\": \"82fc8db0-f366-4029-b6ba-e148b3639ef9\",\n" +
            "          \"url\": \"https://www.last.fm/music/Edenbridge\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/d07daf0638db89411e5e6ac38aac5dae.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/d07daf0638db89411e5e6ac38aac5dae.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/d07daf0638db89411e5e6ac38aac5dae.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/d07daf0638db89411e5e6ac38aac5dae.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/d07daf0638db89411e5e6ac38aac5dae.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Eddie Cochran\",\n" +
            "          \"listeners\": \"440278\",\n" +
            "          \"mbid\": \"17995d1c-5b3c-4ee9-98f5-105ee3b4ada1\",\n" +
            "          \"url\": \"https://www.last.fm/music/Eddie+Cochran\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/06214e09bfaf4b8fb4638159f42072bf.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/06214e09bfaf4b8fb4638159f42072bf.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/06214e09bfaf4b8fb4638159f42072bf.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/06214e09bfaf4b8fb4638159f42072bf.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/06214e09bfaf4b8fb4638159f42072bf.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Edward Maya\",\n" +
            "          \"listeners\": \"287622\",\n" +
            "          \"mbid\": \"257891db-1f69-4660-894d-075e355431a8\",\n" +
            "          \"url\": \"https://www.last.fm/music/Edward+Maya\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/9af4e9b81fbf461c9b400fe88087d81b.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/9af4e9b81fbf461c9b400fe88087d81b.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/9af4e9b81fbf461c9b400fe88087d81b.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/9af4e9b81fbf461c9b400fe88087d81b.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/9af4e9b81fbf461c9b400fe88087d81b.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Welle:Erdball\",\n" +
            "          \"listeners\": \"72297\",\n" +
            "          \"mbid\": \"67d6773b-f927-493a-ae48-b5ad7c522291\",\n" +
            "          \"url\": \"https://www.last.fm/music/Welle:Erdball\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/913a5b12ce924275a542dd5340d42f72.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/913a5b12ce924275a542dd5340d42f72.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/913a5b12ce924275a542dd5340d42f72.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/913a5b12ce924275a542dd5340d42f72.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/913a5b12ce924275a542dd5340d42f72.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Eden\",\n" +
            "          \"listeners\": \"112892\",\n" +
            "          \"mbid\": \"f6337a40-e306-4d01-85cd-dd40be74dff5\",\n" +
            "          \"url\": \"https://www.last.fm/music/Eden\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/deb26af8d24ae9204ee082fc6e4d3e8a.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/deb26af8d24ae9204ee082fc6e4d3e8a.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/deb26af8d24ae9204ee082fc6e4d3e8a.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/deb26af8d24ae9204ee082fc6e4d3e8a.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/deb26af8d24ae9204ee082fc6e4d3e8a.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Eddie Money\",\n" +
            "          \"listeners\": \"417778\",\n" +
            "          \"mbid\": \"0e990816-cb3e-4930-a2eb-77909e42cd66\",\n" +
            "          \"url\": \"https://www.last.fm/music/Eddie+Money\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/e7e6964fc37543968068b282cac06a35.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/e7e6964fc37543968068b282cac06a35.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/e7e6964fc37543968068b282cac06a35.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/e7e6964fc37543968068b282cac06a35.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/e7e6964fc37543968068b282cac06a35.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Lisa Ekdahl\",\n" +
            "          \"listeners\": \"267706\",\n" +
            "          \"mbid\": \"560c4706-0868-4c89-be8b-b26fb7754aba\",\n" +
            "          \"url\": \"https://www.last.fm/music/Lisa+Ekdahl\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/21b05c480e224725b2b196842e42efa8.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/21b05c480e224725b2b196842e42efa8.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/21b05c480e224725b2b196842e42efa8.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/21b05c480e224725b2b196842e42efa8.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/21b05c480e224725b2b196842e42efa8.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Ed Harcourt\",\n" +
            "          \"listeners\": \"250842\",\n" +
            "          \"mbid\": \"0cda9358-1def-49aa-a0ff-10320f40522f\",\n" +
            "          \"url\": \"https://www.last.fm/music/Ed+Harcourt\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/5bb5dbb96d5944a0a8fc728d4640a940.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/5bb5dbb96d5944a0a8fc728d4640a940.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/5bb5dbb96d5944a0a8fc728d4640a940.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/5bb5dbb96d5944a0a8fc728d4640a940.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/5bb5dbb96d5944a0a8fc728d4640a940.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Jagged Edge\",\n" +
            "          \"listeners\": \"531198\",\n" +
            "          \"mbid\": \"8b4d99eb-7a54-4648-b299-8e1564d11385\",\n" +
            "          \"url\": \"https://www.last.fm/music/Jagged+Edge\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/645602cc68c04d29a15d93938492b942.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/645602cc68c04d29a15d93938492b942.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/645602cc68c04d29a15d93938492b942.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/645602cc68c04d29a15d93938492b942.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/645602cc68c04d29a15d93938492b942.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Edwin Starr\",\n" +
            "          \"listeners\": \"439789\",\n" +
            "          \"mbid\": \"f27ec8db-af05-4f36-916e-3d57f91ecf5e\",\n" +
            "          \"url\": \"https://www.last.fm/music/Edwin+Starr\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/ca1300853f0d41f9b06e64c9135ca662.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/ca1300853f0d41f9b06e64c9135ca662.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/ca1300853f0d41f9b06e64c9135ca662.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/ca1300853f0d41f9b06e64c9135ca662.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/ca1300853f0d41f9b06e64c9135ca662.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Edyta Górniak\",\n" +
            "          \"listeners\": \"107798\",\n" +
            "          \"mbid\": \"ca59a38e-cf39-4d95-ac03-b6ca4f43fd8f\",\n" +
            "          \"url\": \"https://www.last.fm/music/Edyta+G%C3%B3rniak\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/e76641286875881041e4bb424400b219.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/e76641286875881041e4bb424400b219.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/e76641286875881041e4bb424400b219.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/e76641286875881041e4bb424400b219.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/e76641286875881041e4bb424400b219.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Edwyn Collins\",\n" +
            "          \"listeners\": \"274727\",\n" +
            "          \"mbid\": \"14c0c282-e0c1-46fe-acd1-9a015ba721c5\",\n" +
            "          \"url\": \"https://www.last.fm/music/Edwyn+Collins\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/57d14a13d9eb417a8dc70e86417ff812.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/57d14a13d9eb417a8dc70e86417ff812.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/57d14a13d9eb417a8dc70e86417ff812.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/57d14a13d9eb417a8dc70e86417ff812.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/57d14a13d9eb417a8dc70e86417ff812.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Edwin McCain\",\n" +
            "          \"listeners\": \"351084\",\n" +
            "          \"mbid\": \"f362fdd1-3ddd-4c4e-9629-ef170b08d093\",\n" +
            "          \"url\": \"https://www.last.fm/music/Edwin+McCain\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/8e1f4896de49462193449147c3b87475.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/8e1f4896de49462193449147c3b87475.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/8e1f4896de49462193449147c3b87475.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/8e1f4896de49462193449147c3b87475.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/8e1f4896de49462193449147c3b87475.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Sir Edward Elgar\",\n" +
            "          \"listeners\": \"422998\",\n" +
            "          \"mbid\": \"4e60a56a-514a-4a19-a3cc-49927c96b3cb\",\n" +
            "          \"url\": \"https://www.last.fm/music/Sir+Edward+Elgar\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/acdfb5e87f34446582a15431c13c54df.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/acdfb5e87f34446582a15431c13c54df.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/acdfb5e87f34446582a15431c13c54df.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/acdfb5e87f34446582a15431c13c54df.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/acdfb5e87f34446582a15431c13c54df.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Enduser\",\n" +
            "          \"listeners\": \"90591\",\n" +
            "          \"mbid\": \"12a9818a-60aa-4482-a8fa-05ed7949b178\",\n" +
            "          \"url\": \"https://www.last.fm/music/Enduser\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/02c7004444324ea08d4e0010c0951a0e.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/02c7004444324ea08d4e0010c0951a0e.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/02c7004444324ea08d4e0010c0951a0e.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/02c7004444324ea08d4e0010c0951a0e.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/02c7004444324ea08d4e0010c0951a0e.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Kathleen Edwards\",\n" +
            "          \"listeners\": \"204644\",\n" +
            "          \"mbid\": \"7e915503-cc34-43fa-a6d7-986ff909d5e9\",\n" +
            "          \"url\": \"https://www.last.fm/music/Kathleen+Edwards\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/9afb0ec466d5430b8b29836553cc2f61.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/9afb0ec466d5430b8b29836553cc2f61.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/9afb0ec466d5430b8b29836553cc2f61.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/9afb0ec466d5430b8b29836553cc2f61.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/9afb0ec466d5430b8b29836553cc2f61.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Eddy Grant\",\n" +
            "          \"listeners\": \"303371\",\n" +
            "          \"mbid\": \"0cf0583a-fcfd-4f07-b573-95273ec4bdb5\",\n" +
            "          \"url\": \"https://www.last.fm/music/Eddy+Grant\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/8f49f1ee97454cb6cca7246bf3479f00.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/8f49f1ee97454cb6cca7246bf3479f00.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/8f49f1ee97454cb6cca7246bf3479f00.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/8f49f1ee97454cb6cca7246bf3479f00.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/8f49f1ee97454cb6cca7246bf3479f00.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Edan\",\n" +
            "          \"listeners\": \"110472\",\n" +
            "          \"mbid\": \"d747ba37-3af2-414b-80e8-49607d63d1a4\",\n" +
            "          \"url\": \"https://www.last.fm/music/Edan\",\n" +
            "          \"streamable\": \"0\",\n" +
            "          \"image\": [\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/34s/a2031d23719947e88c88f6b803b2b63d.png\",\n" +
            "              \"size\": \"small\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/64s/a2031d23719947e88c88f6b803b2b63d.png\",\n" +
            "              \"size\": \"medium\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/174s/a2031d23719947e88c88f6b803b2b63d.png\",\n" +
            "              \"size\": \"large\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/a2031d23719947e88c88f6b803b2b63d.png\",\n" +
            "              \"size\": \"extralarge\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"#text\": \"https://lastfm-img2.akamaized.net/i/u/300x300/a2031d23719947e88c88f6b803b2b63d.png\",\n" +
            "              \"size\": \"mega\"\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    \"@attr\": {\n" +
            "      \"for\": \"ed\"\n" +
            "    }\n" +
            "  }\n" +
            "}" ;

    public String getJSONInput(){
        return getJSONInput();
    }
}
