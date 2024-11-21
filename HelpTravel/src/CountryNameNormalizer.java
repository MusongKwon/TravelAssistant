import java.util.HashMap;

public class CountryNameNormalizer {
    public static String normalizeCountryName(String input) {
        input = input.toLowerCase().trim();
        if (nameMapping.containsKey(input)) {
            return nameMapping.get(input);
        }
        // Fallback to find the closest match
        return findClosestMatch(input);
    }

    private static String findClosestMatch(String input) {
        String closestMatch = "unknown";
        int minDistance = Integer.MAX_VALUE;

        for (String key : nameMapping.keySet()) {
            int distance = levenshteinDistance(input, key);
            if (distance < minDistance) {
                minDistance = distance;
                closestMatch = nameMapping.get(key);
            }
        }

        // If the match is too far off, return "unknown"
        return (minDistance <= 3) ? closestMatch : "unknown";
    }

    private static int levenshteinDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int cost = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    private static final HashMap<String, String> nameMapping;
    static {
        nameMapping = new HashMap<>();
        nameMapping.put("andorra", "Andorra");
        nameMapping.put("united arab emirates", "United Arab Emirates");
        nameMapping.put("uae", "United Arab Emirates");
        nameMapping.put("afghanistan", "Afghanistan");
        nameMapping.put("antigua and barbuda", "Antigua and Barbuda");
        nameMapping.put("antigua", "Antigua and Barbuda");
        nameMapping.put("barbuda", "Antigua and Barbuda");
        nameMapping.put("anguilla", "Anguilla");
        nameMapping.put("albania", "Albania");
        nameMapping.put("shqiperia", "Albania");
        nameMapping.put("armenia", "Armenia");
        nameMapping.put("angola", "Angola");
        nameMapping.put("argentina", "Argentina");
        nameMapping.put("american samoa", "American Samoa");
        nameMapping.put("austria", "Austria");
        nameMapping.put("australia", "Australia");
        nameMapping.put("aruba", "Aruba");
        nameMapping.put("azerbaijan", "Azerbaijan");
        nameMapping.put("bosnia and herzegovina", "Bosnia and Herzegovina");
        nameMapping.put("bosnia", "Bosnia and Herzegovina");
        nameMapping.put("herzegovina", "Bosnia and Herzegovina");
        nameMapping.put("barbados", "Barbados");
        nameMapping.put("bangladesh", "Bangladesh");
        nameMapping.put("belgium", "Belgium");
        nameMapping.put("burkina faso", "Burkina Faso");
        nameMapping.put("bulgaria", "Bulgaria");
        nameMapping.put("bahrain", "Bahrain");
        nameMapping.put("burundi", "Burundi");
        nameMapping.put("benin", "Benin");
        //nameMapping.put("", "Saint Barthélemy");
        nameMapping.put("bermuda", "Bermuda");
        nameMapping.put("brunei", "Brunei");
        nameMapping.put("bolivia", "Bolivia");
        nameMapping.put("brazil", "Brazil");
        nameMapping.put("bahamas", "Bahamas");
        nameMapping.put("the bahamas", "Bahamas");
        nameMapping.put("bhutan", "Bhutan");
        nameMapping.put("botswana", "Botswana");
        nameMapping.put("belarus", "Belarus");
        nameMapping.put("belize", "Belize");
        nameMapping.put("canada", "Canada");
        nameMapping.put("cocos islands", "Cocos Islands");
        nameMapping.put("keeling islands", "Cocos Islands");
        nameMapping.put("democratic republic of the congo", "Democratic Republic of the Congo");
        nameMapping.put("drc", "Democratic Republic of the Congo");
        nameMapping.put("central african republic", "Central African Republic");
        nameMapping.put("republic of the congo", "Republic of the Congo");
        nameMapping.put("congo", "Republic of the Congo");
        nameMapping.put("switzerland", "Switzerland");
        nameMapping.put("swiss republic", "Switzerland");
        nameMapping.put("ivory coast", "Ivory Coast");
        nameMapping.put("cote d'ivoire", "Ivory Coast");
        nameMapping.put("cook islands", "Cook Islands");
        nameMapping.put("chile", "Chile");
        nameMapping.put("cameroon", "Cameroon");
        nameMapping.put("china", "China");
        nameMapping.put("people's republic of china", "China");
        nameMapping.put("prc", "China");
        nameMapping.put("colombia", "Colombia");
        nameMapping.put("costa rica", "Costa Rica");
        nameMapping.put("cuba", "Cuba");
        nameMapping.put("cape verde", "Cape Verde");
        nameMapping.put("christmas island", "Christmas Island");
        nameMapping.put("cyprus", "Cyprus");
        nameMapping.put("czech republic", "Czech Republic");
        nameMapping.put("czechia", "Czech Republic");
        nameMapping.put("bohemia", "Czech Republic");
        nameMapping.put("germany", "Germany");
        nameMapping.put("deutschland", "Germany");
        nameMapping.put("djibouti", "Djibouti");
        nameMapping.put("denmark", "Denmark");
        nameMapping.put("dominica", "Dominica");
        nameMapping.put("dominican republic", "Dominican Republic");
        nameMapping.put("algeria", "Algeria");
        nameMapping.put("ecuador", "Ecuador");
        nameMapping.put("estonia", "Estonia");
        nameMapping.put("egypt", "Egypt");
        nameMapping.put("western sahara", "Western Sahara");
        nameMapping.put("eritrea", "Eritrea");
        nameMapping.put("spain", "Spain");
        nameMapping.put("ethiopia", "Ethiopia");
        nameMapping.put("abyssinia", "Ethiopia");
        nameMapping.put("finland", "Finland");
        nameMapping.put("fiji", "Fiji");
        nameMapping.put("falkland islands", "Falkland Islands");
        nameMapping.put("falkland", "Falkland Islands");
        nameMapping.put("micronesia", "Micronesia");
        nameMapping.put("faroe islands", "Faroe Islands");
        nameMapping.put("faroe", "Faroe Islands");
        nameMapping.put("france", "France");
        nameMapping.put("gabon", "Gabon");
        nameMapping.put("united kingdom", "United Kingdom");
        nameMapping.put("uk", "United Kingdom");
        nameMapping.put("britain", "United Kingdom");
        nameMapping.put("great britain", "United Kingdom");
        nameMapping.put("england", "United Kingdom");
        nameMapping.put("scotland", "United Kingdom");
        nameMapping.put("wales", "United Kingdom");
        nameMapping.put("northern ireland", "United Kingdom");
        nameMapping.put("grenada", "Grenada");
        nameMapping.put("georgia", "Georgia");
        nameMapping.put("french guiana", "French Guiana");
        nameMapping.put("guernsey", "Guernsey");
        nameMapping.put("ghana", "Ghana");
        nameMapping.put("gibraltar", "Gibraltar");
        nameMapping.put("greenland", "Greenland");
        nameMapping.put("gambia", "Gambia");
        nameMapping.put("the gambia", "Gambia");
        nameMapping.put("guinea", "Guinea");
        nameMapping.put("guadeloupe", "Guadeloupe");
        nameMapping.put("equatorial guinea", "Equatorial Guinea");
        nameMapping.put("greece", "Greece");
        nameMapping.put("hellas", "Greece");
        nameMapping.put("south georgia and the south sandwich islands", "South Georgia and the South Sandwich Islands");
        nameMapping.put("south georgia", "South Georgia and the South Sandwich Islands");
        nameMapping.put("south sandwich islands", "South Georgia and the South Sandwich Islands");
        nameMapping.put("guatemala", "Guatemala");
        nameMapping.put("guam", "Guam");
        nameMapping.put("guinea-bissau", "Guinea-Bissau");
        nameMapping.put("guyana", "Guyana");
        nameMapping.put("hong kong", "Hong Kong");
        nameMapping.put("honduras", "Honduras");
        nameMapping.put("croatia", "Croatia");
        nameMapping.put("hrvatska", "Croatia");
        nameMapping.put("haiti", "Haiti");
        nameMapping.put("hungary", "Hungary");
        nameMapping.put("indonesia", "Indonesia");
        nameMapping.put("ireland", "Ireland");
        nameMapping.put("israel", "Israel");
        nameMapping.put("isle of man", "Isle of Man");
        nameMapping.put("mann", "Isle of Man");
        nameMapping.put("india", "India");
        nameMapping.put("bharat", "India");
        nameMapping.put("hindustan", "India");
        nameMapping.put("iraq", "Iraq");
        nameMapping.put("assyria", "Iraq");
        nameMapping.put("iran", "Iran");
        nameMapping.put("persia", "Iran");
        nameMapping.put("iceland", "Iceland");
        nameMapping.put("italy", "Italy");
        nameMapping.put("jersey", "Jersey");
        nameMapping.put("jamaica", "Jamaica");
        nameMapping.put("jordan", "Jordan");
        nameMapping.put("japan", "Japan");
        nameMapping.put("nippon", "Japan");
        nameMapping.put("kenya", "Kenya");
        nameMapping.put("kyrgyzstan", "Kyrgyzstan");
        nameMapping.put("cambodia", "Cambodia");
        nameMapping.put("khmer", "Cambodia");
        nameMapping.put("kiribati", "Kiribati");
        nameMapping.put("comoros", "Comoros");
        nameMapping.put("saint kitts and nevis", "Saint Kitts and Nevis");
        nameMapping.put("st. kitts and nevis", "Saint Kitts and Nevis");
        nameMapping.put("saint christopher and nevis", "Saint Kitts and Nevis");
        nameMapping.put("st. christopher and nevis", "Saint Kitts and Nevis");
        nameMapping.put("saint kitts", "Saint Kitts and Nevis");
        nameMapping.put("st. kitts", "Saint Kitts and Nevis");
        nameMapping.put("saint christopher", "Saint Kitts and Nevis");
        nameMapping.put("st. christopher", "Saint Kitts and Nevis");
        nameMapping.put("nevis", "Saint Kitts and Nevis");
        nameMapping.put("north korea", "North Korea");
        nameMapping.put("dprk", "North Korea");
        nameMapping.put("democratic people's republic of korea", "North Korea");
        nameMapping.put("south korea", "South Korea");
        nameMapping.put("korea", "South Korea");
        nameMapping.put("rok", "South Korea");
        nameMapping.put("republic of korea", "South Korea");
        nameMapping.put("kuwait", "Kuwait");
        nameMapping.put("cayman islands", "Cayman Islands");
        nameMapping.put("caymans", "Cayman Islands");
        nameMapping.put("kazakhstan", "Kazakhstan");
        nameMapping.put("laos", "Laos");
        nameMapping.put("lebanon", "Lebanon");
        nameMapping.put("saint lucia", "Saint Lucia");
        nameMapping.put("st. lucia", "Saint Lucia");
        nameMapping.put("liechtenstein", "Liechtenstein");
        nameMapping.put("sri lanka", "Sri Lanka");
        nameMapping.put("ceylon", "Sri Lanka");
        nameMapping.put("liberia", "Liberia");
        nameMapping.put("lesotho", "Lesotho");
        nameMapping.put("lithuania", "Lithuania");
        nameMapping.put("luxembourg", "Luxembourg");
        nameMapping.put("latvia", "Latvia");
        nameMapping.put("libya", "Libya");
        nameMapping.put("morocco", "Morocco");
        nameMapping.put("monaco", "Monaco");
        nameMapping.put("moldova", "Moldova");
        nameMapping.put("montenegro", "Montenegro");
        nameMapping.put("saint martin", "Saint Martin");
        nameMapping.put("st. martin", "Saint Martin");
        nameMapping.put("sint maarten", "Saint Martin");
        nameMapping.put("madagascar", "Madagascar");
        nameMapping.put("marshall islands", "Marshall Islands");
        nameMapping.put("macedonia", "Macedonia");
        nameMapping.put("north macedonia", "Macedonia");
        nameMapping.put("mali", "Mali");
        nameMapping.put("myanmar", "Myanmar");
        nameMapping.put("burma", "Myanmar");
        nameMapping.put("mongolia", "Mongolia");
        nameMapping.put("macao", "Macao");
        nameMapping.put("northern mariana islands", "Northern Mariana Islands");
        nameMapping.put("mariana islands", "Northern Mariana Islands");
        nameMapping.put("marianas", "Northern Mariana Islands");
        nameMapping.put("martinique", "Martinique");
        nameMapping.put("mauritania", "Mauritania");
        nameMapping.put("montserrat", "Montserrat");
        nameMapping.put("malta", "Malta");
        nameMapping.put("mauritius", "Mauritius");
        nameMapping.put("maldives", "Maldives");
        nameMapping.put("malawi", "Malawi");
        nameMapping.put("mexico", "Mexico");
        nameMapping.put("malaysia", "Malaysia");
        nameMapping.put("mozambique", "Mozambique");
        nameMapping.put("namibia", "Namibia");
        nameMapping.put("new caledonia", "New Caledonia");
        nameMapping.put("niger", "Niger");
        nameMapping.put("norfolk island", "Norfolk Island");
        nameMapping.put("nigeria", "Nigeria");
        nameMapping.put("nicaragua", "Nicaragua");
        nameMapping.put("netherlands", "Netherlands");
        nameMapping.put("holland", "Netherlands");
        nameMapping.put("norway", "Norway");
        nameMapping.put("nepal", "Nepal");
        nameMapping.put("niue", "Niue");
        nameMapping.put("new zealand", "New Zealand");
        nameMapping.put("oman", "Oman");
        nameMapping.put("panama", "Panama");
        nameMapping.put("peru", "Peru");
        nameMapping.put("french polynesia", "French Polynesia");
        nameMapping.put("papua new guinea", "Papua New Guinea");
        nameMapping.put("philippines", "Philippines");
        nameMapping.put("the philippines", "Philippines");
        nameMapping.put("filipinas", "Philippines");
        nameMapping.put("philippine islands", "Philippines");
        nameMapping.put("pakistan", "Pakistan");
        nameMapping.put("poland", "Poland");
        nameMapping.put("saint pierre and miquelon", "Saint Pierre and Miquelon");
        nameMapping.put("st. pierre and miquelon", "Saint Pierre and Miquelon");
        nameMapping.put("saint pierre", "Saint Pierre and Miquelon");
        nameMapping.put("st. pierre", "Saint Pierre and Miquelon");
        nameMapping.put("miquelon", "Saint Pierre and Miquelon");
        nameMapping.put("pitcairn", "Pitcairn");
        nameMapping.put("pitcairn islands", "Pitcairn");
        nameMapping.put("puerto rico", "Puerto Rico");
        nameMapping.put("palestinian territory", "Palestinian Territory");
        nameMapping.put("palestine", "Palestinian Territory");
        nameMapping.put("west bank", "Palestinian Territory");
        nameMapping.put("gaza strip", "Palestinian Territory");
        nameMapping.put("portugal", "Portugal");
        nameMapping.put("palau", "Palau");
        nameMapping.put("paraguay", "Paraguay");
        nameMapping.put("qatar", "Qatar");
        nameMapping.put("reunion", "Reunion");
        nameMapping.put("la reunion", "Reunion");
        nameMapping.put("romania", "Romania");
        nameMapping.put("serbia", "Serbia");
        nameMapping.put("russia", "Russia");
        nameMapping.put("rwanda", "Rwanda");
        nameMapping.put("saudi arabia", "Saudi Arabia");
        nameMapping.put("saudi", "Saudi Arabia");
        nameMapping.put("arabia", "Saudi Arabia");
        nameMapping.put("solomon islands", "Solomon Islands");
        nameMapping.put("solomons", "Solomon Islands");
        nameMapping.put("the solomons", "Solomon Islands");
        nameMapping.put("seychelles", "Seychelles");
        nameMapping.put("sudan", "Sudan");
        nameMapping.put("sweden", "Sweden");
        nameMapping.put("singapore", "Singapore");
        nameMapping.put("saint helena", "Saint Helena");
        nameMapping.put("st. helena", "Saint Helena");
        nameMapping.put("slovenia", "Slovenia");
        nameMapping.put("svalbard and jan mayen", "Svalbard and Jan Mayen");
        nameMapping.put("svalbard", "Svalbard and Jan Mayen");
        nameMapping.put("jan mayen", "Svalbard and Jan Mayen");
        nameMapping.put("slovakia", "Slovakia");
        nameMapping.put("sierra leone", "Sierra Leone");
        nameMapping.put("san marino", "San Marino");
        nameMapping.put("senegal", "Senegal");
        nameMapping.put("somalia", "Somalia");
        nameMapping.put("somaliland", "Somalia");
        nameMapping.put("suriname", "Suriname");
        nameMapping.put("south sudan", "South Sudan");
        nameMapping.put("sao tome and principe", "Sao Tome and Principe");
        nameMapping.put("sao tome", "Sao Tome and Principe");
        nameMapping.put("principe", "Sao Tome and Principe");
        nameMapping.put("el salvador", "El Salvador");
        nameMapping.put("syria", "Syria");
        nameMapping.put("swaziland", "Swaziland");
        nameMapping.put("eswatini", "Swaziland");
        nameMapping.put("turks and caicos islands", "Turks and Caicos Islands");
        nameMapping.put("turks and caicos", "Turks and Caicos Islands");
        nameMapping.put("turks islands", "Turks and Caicos Islands");
        nameMapping.put("caicos islands", "Turks and Caicos Islands");
        nameMapping.put("chad", "Chad");
        nameMapping.put("togo", "Togo");
        nameMapping.put("thailand", "Thailand");
        nameMapping.put("siam", "Thailand");
        nameMapping.put("tajikistan", "Tajikistan");
        nameMapping.put("east timor", "East Timor");
        nameMapping.put("timor-leste", "East Timor");
        nameMapping.put("turkmenistan", "Turkmenistan");
        nameMapping.put("tunisia", "Tunisia");
        nameMapping.put("tonga", "Tonga");
        nameMapping.put("turkey", "Turkey");
        nameMapping.put("turkiye", "Turkey");
        nameMapping.put("anatolia", "Turkey");
        nameMapping.put("trinidad and tobago", "Trinidad and Tobago");
        nameMapping.put("trinidad", "Trinidad and Tobago");
        nameMapping.put("tobago", "Trinidad and Tobago");
        nameMapping.put("tuvalu", "Tuvalu");
        nameMapping.put("taiwan", "Taiwan");
        nameMapping.put("republic of china", "Taiwan");
        nameMapping.put("tanzania", "Tanzania");
        nameMapping.put("ukraine", "Ukraine");
        nameMapping.put("uganda", "Uganda");
        nameMapping.put("united states", "United States");
        nameMapping.put("usa", "United States");
        nameMapping.put("united states of america", "United States");
        nameMapping.put("america", "United States");
        nameMapping.put("us of a", "United States");
        nameMapping.put("uruguay", "Uruguay");
        nameMapping.put("uzbekistan", "Uzbekistan");
        nameMapping.put("vatican", "Vatican");
        nameMapping.put("vatican city", "Vatican");
        nameMapping.put("holy see", "Vatican");
        nameMapping.put("saint vincent and the grenadines", "Saint Vincent and the Grenadines");
        nameMapping.put("st. vincent and the grenadines", "Saint Vincent and the Grenadines");
        nameMapping.put("saint vincent", "Saint Vincent and the Grenadines");
        nameMapping.put("st. vincent", "Saint Vincent and the Grenadines");
        nameMapping.put("the grenadines", "Saint Vincent and the Grenadines");
        nameMapping.put("venezuela", "Venezuela");
        nameMapping.put("british virgin islands", "British Virgin Islands");
        nameMapping.put("virgin islands", "British Virgin Islands");
        nameMapping.put("bvi", "British Virgin Islands");
        nameMapping.put("us virgin islands", "U.S. Virgin Islands");
        nameMapping.put("united states virgin islands", "U.S. Virgin Islands");
        nameMapping.put("virgin islands of the united states", "U.S. Virgin Islands");
        nameMapping.put("american virgin islands", "U.S. Virgin Islands");
        nameMapping.put("vietnam", "Vietnam");
        nameMapping.put("vanuatu", "Vanuatu");
        nameMapping.put("wallis and futuna", "Wallis and Futuna");
        nameMapping.put("wallis islands", "Wallis and Futuna");
        nameMapping.put("futuna island", "Wallis and Futuna");
        nameMapping.put("samoa", "Samoa");
        nameMapping.put("kosovo", "Kosovo");
        nameMapping.put("yemen", "Yemen");
        nameMapping.put("mayotte", "Mayotte");
        nameMapping.put("south africa", "South Africa");
        nameMapping.put("zambia", "Zambia");
        nameMapping.put("zimbabwe", "Zimbabwe");
        nameMapping.put("rhodesia", "Zimbabwe");
    }
}
