CREATE DATABASE  IF NOT EXISTS `Dream11` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `Dream11`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: Dream11
-- ------------------------------------------------------
-- Server version	5.7.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `IPLTeam`
--

DROP TABLE IF EXISTS `IPLTeam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IPLTeam` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IPLTeam`
--

LOCK TABLES `IPLTeam` WRITE;
/*!40000 ALTER TABLE `IPLTeam` DISABLE KEYS */;
INSERT INTO `IPLTeam` VALUES (101,'csk'),(102,'mi'),(103,'srh'),(104,'dc');
/*!40000 ALTER TABLE `IPLTeam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Player`
--

DROP TABLE IF EXISTS `Player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Player` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `teamId` int(11) NOT NULL,
  `pointScoredCurrentMatch` int(11) DEFAULT NULL,
  `pointScoredThisSeason` int(11) DEFAULT NULL,
  `playerType` varchar(45) DEFAULT NULL,
  `imgUrl` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Player`
--

LOCK TABLES `Player` WRITE;
/*!40000 ALTER TABLE `Player` DISABLE KEYS */;
INSERT INTO `Player` VALUES (1,'Shane Watson',101,0,250,'Allrounder','#'),(2,'Faf Du plesis',101,0,200,'Batsman','/images/csk/watson.png'),(3,'Rayudu',101,0,190,'Batsman','/images/'),(4,'Suresh Raina',101,0,198,'Allrounder','#'),(5,'M S Dhoni',101,0,300,'Batsman WC','#'),(6,'Ravindra jadeja',101,0,108,'Allrounder','#'),(7,'Dwayne Bravo',101,0,200,'Allrounder','#'),(8,'Deepak chahar',101,0,150,'Bowler','#'),(9,'Imran Tahir',101,0,190,'Bowler','#'),(10,'Harbhajan Singh',101,0,120,'Bowler','#'),(11,'Shardul Thakur',101,0,100,'Bowler','#'),(12,'Rohit Sharma',102,0,230,'Batsman','#'),(13,'Quinton de kock',102,0,180,'Batsman','#'),(14,'Suryakumar Yadav',102,0,140,'Batsman','#'),(15,'Ishan kishan',102,0,90,'Batsman','#'),(16,'Krunal Pandya',102,0,100,'Allrounder','#'),(17,'hardik pandya',102,0,200,'Allrounder','#'),(18,'kieron pollard',102,0,160,'Allrounder','#'),(19,'Jjayant yadav',102,0,100,'Allrounder','#'),(20,'Rahul Chahar',102,0,50,'Bowler','#'),(21,'Lasith Malinga',102,0,100,'Bowler','#'),(22,'Jasprit BBumrah',102,0,200,'Bowler','#');
/*!40000 ALTER TABLE `Player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Team`
--

DROP TABLE IF EXISTS `Team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `captain_id` int(11) DEFAULT NULL,
  `vice_captain_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `match_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=158 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Team`
--

LOCK TABLES `Team` WRITE;
/*!40000 ALTER TABLE `Team` DISABLE KEYS */;
INSERT INTO `Team` VALUES (156,'shadowKnights',0,0,1,142),(157,'shadowKnights',0,0,2,142);
/*!40000 ALTER TABLE `Team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `current_state`
--

DROP TABLE IF EXISTS `current_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `current_state` (
  `id` int(11) NOT NULL,
  `match_id` int(11) DEFAULT NULL,
  `teampoints1` int(11) DEFAULT NULL,
  `teampoints2` int(11) DEFAULT NULL,
  `ballsplayed` int(11) DEFAULT NULL,
  `inning` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `current_state`
--

LOCK TABLES `current_state` WRITE;
/*!40000 ALTER TABLE `current_state` DISABLE KEYS */;
/*!40000 ALTER TABLE `current_state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `match`
--

DROP TABLE IF EXISTS `match`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `match` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(45) DEFAULT NULL,
  `result` varchar(45) DEFAULT NULL,
  `userid1` int(11) DEFAULT NULL,
  `userid2` int(11) DEFAULT NULL,
  `dateOfMatch` datetime DEFAULT NULL,
  `teamid1` int(11) DEFAULT NULL,
  `teamid2` int(11) DEFAULT NULL,
  `iplTeam1Id` int(11) DEFAULT NULL,
  `iplTeam2Id` int(11) DEFAULT NULL,
  `score1` int(11) DEFAULT '0',
  `score2` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `match`
--

LOCK TABLES `match` WRITE;
/*!40000 ALTER TABLE `match` DISABLE KEYS */;
INSERT INTO `match` VALUES (142,'upcoming','not-played',1,2,'2019-06-30 09:29:59',156,157,101,102,324,257);
/*!40000 ALTER TABLE `match` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_has_players`
--

DROP TABLE IF EXISTS `team_has_players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_has_players` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `team_id` int(11) DEFAULT NULL,
  `player_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2848 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_has_players`
--

LOCK TABLES `team_has_players` WRITE;
/*!40000 ALTER TABLE `team_has_players` DISABLE KEYS */;
INSERT INTO `team_has_players` VALUES (1715,37,3),(1716,37,6),(1717,37,8),(1718,37,9),(1719,38,3),(1720,38,4),(1721,38,7),(1722,38,5),(1723,39,1),(1724,39,2),(1725,39,4),(1726,39,6),(1727,39,7),(1728,39,9),(1729,39,8),(1730,39,5),(1731,39,14),(1732,39,15),(1733,39,17),(1734,40,4),(1735,40,6),(1736,40,8),(1737,40,10),(1738,40,11),(1739,40,14),(1740,40,16),(1741,40,17),(1742,40,19),(1743,40,15),(1744,40,21),(1745,41,2),(1746,41,4),(1747,41,5),(1748,41,7),(1749,41,9),(1750,41,10),(1751,41,14),(1752,41,17),(1753,41,19),(1754,41,16),(1755,41,15),(1756,42,4),(1757,42,6),(1758,42,10),(1759,42,14),(1760,42,16),(1761,42,18),(1762,42,20),(1763,42,22),(1764,42,17),(1765,42,15),(1766,42,13),(1767,43,5),(1768,43,13),(1769,43,17),(1770,43,20),(1771,43,22),(1772,43,14),(1773,43,15),(1774,44,10),(1775,44,7),(1776,44,5),(1777,44,17),(1778,44,20),(1779,44,14),(1780,45,3),(1781,45,6),(1782,45,7),(1783,45,8),(1784,45,9),(1785,45,15),(1786,45,18),(1787,45,20),(1788,45,17),(1789,45,13),(1790,45,16),(1791,46,3),(1792,46,6),(1793,46,8),(1794,46,10),(1795,46,13),(1796,46,16),(1797,46,17),(1798,46,19),(1799,46,21),(1800,46,15),(1801,46,14),(1802,47,3),(1803,47,5),(1804,47,6),(1805,47,8),(1806,48,4),(1807,48,6),(1808,48,7),(1809,48,2),(1810,48,3),(1811,49,3),(1812,49,4),(1813,49,5),(1814,49,6),(1815,49,7),(1816,50,2),(1817,50,5),(1818,50,7),(1819,51,4),(1820,51,7),(1821,51,9),(1822,52,1),(1823,52,3),(1824,52,5),(1825,52,6),(1826,53,3),(1827,53,5),(1828,53,14),(1829,53,16),(1830,53,20),(1831,53,21),(1832,53,17),(1833,53,13),(1834,54,2),(1835,54,3),(1836,54,5),(1837,54,6),(1838,54,7),(1839,55,2),(1840,55,4),(1841,55,5),(1842,55,13),(1843,55,14),(1844,55,15),(1845,56,5),(1846,56,15),(1847,56,18),(1848,56,20),(1849,56,21),(1850,56,19),(1851,57,4),(1852,57,5),(1853,57,6),(1854,57,7),(1855,58,16),(1856,58,18),(1857,58,20),(1858,59,2),(1859,59,4),(1860,59,6),(1861,60,2),(1862,60,4),(1863,60,5),(1864,60,6),(1865,60,7),(1866,60,9),(1867,61,6),(1868,61,15),(1869,61,17),(1870,61,19),(1871,61,20),(1872,61,21),(1873,61,14),(1874,61,13),(1875,62,2),(1876,62,14),(1877,62,5),(1878,62,15),(1879,62,7),(1880,62,18),(1881,63,3),(1882,63,14),(1883,63,16),(1884,63,18),(1885,63,20),(1886,64,6),(1887,64,8),(1888,64,9),(1889,65,2),(1890,65,3),(1891,65,5),(1892,65,6),(1893,65,16),(1894,65,14),(1895,66,5),(1896,66,6),(1897,66,15),(1898,66,16),(1899,66,22),(1900,66,11),(1901,67,3),(1902,67,4),(1903,67,6),(1904,67,9),(1905,68,2),(1906,68,4),(1907,68,6),(1908,68,7),(1909,68,8),(1910,69,3),(1911,69,6),(1912,69,9),(1913,69,11),(1914,70,2),(1915,70,4),(1916,70,6),(1917,71,4),(1918,71,6),(1919,71,7),(1920,72,3),(1921,72,5),(1922,72,15),(1923,73,6),(1924,73,7),(1925,73,8),(1926,74,4),(1927,74,7),(1928,74,10),(1929,74,11),(1930,75,6),(1931,75,4),(1932,75,3),(1933,75,20),(1934,75,18),(1935,75,17),(1936,75,15),(1937,75,14),(1938,75,12),(1939,75,7),(1940,75,8),(1941,76,2),(1942,76,4),(1943,76,6),(1944,76,7),(1945,76,19),(1946,76,16),(1947,76,13),(1948,76,18),(1949,76,22),(1950,76,20),(1951,76,17),(1952,76,14),(1953,76,15),(1954,76,21),(1955,77,5),(1956,77,7),(1957,77,8),(1958,77,9),(1959,77,14),(1960,77,17),(1961,77,19),(1962,77,20),(1963,77,22),(1964,77,13),(1965,77,12),(1966,77,21),(1967,77,18),(1968,78,2),(1969,78,4),(1970,78,6),(1971,78,7),(1972,78,9),(1973,78,10),(1974,78,13),(1975,78,14),(1976,78,15),(1977,78,16),(1978,78,17),(1979,79,2),(1980,79,6),(1981,79,7),(1982,79,9),(1983,79,10),(1984,79,22),(1985,79,21),(1986,79,20),(1987,79,19),(1988,79,18),(1989,79,17),(1990,80,2),(1991,80,4),(1992,80,5),(1993,80,6),(1994,80,7),(1995,80,8),(1996,80,16),(1997,80,17),(1998,80,18),(1999,80,19),(2000,80,20),(2001,81,3),(2002,81,1),(2003,81,2),(2004,81,4),(2005,81,6),(2006,81,5),(2007,81,7),(2008,81,8),(2009,81,9),(2010,81,10),(2011,81,11),(2012,82,1),(2013,82,2),(2014,82,3),(2015,82,4),(2016,82,5),(2017,82,6),(2018,82,8),(2019,82,7),(2020,82,9),(2021,82,10),(2022,82,11),(2023,83,3),(2024,83,5),(2025,83,6),(2026,83,7),(2027,83,8),(2028,83,9),(2029,83,10),(2030,83,11),(2031,83,4),(2032,83,2),(2033,83,1),(2034,84,2),(2035,84,1),(2036,84,3),(2037,84,4),(2038,84,5),(2039,84,6),(2040,84,7),(2041,84,8),(2042,84,9),(2043,84,10),(2044,84,11),(2045,85,5),(2046,85,7),(2047,85,8),(2048,85,10),(2049,85,11),(2050,85,9),(2051,85,6),(2052,85,4),(2053,85,3),(2054,85,2),(2055,85,1),(2056,86,12),(2057,86,13),(2058,86,14),(2059,86,15),(2060,86,16),(2061,86,17),(2062,86,18),(2063,86,19),(2064,86,20),(2065,86,21),(2066,86,22),(2067,87,2),(2068,87,4),(2069,87,7),(2070,87,8),(2071,87,10),(2072,87,18),(2073,87,16),(2074,87,15),(2075,87,14),(2076,87,13),(2077,87,20),(2078,88,1),(2079,88,2),(2080,88,13),(2081,88,12),(2082,88,14),(2083,88,15),(2084,88,17),(2085,88,16),(2086,88,20),(2087,88,19),(2088,88,18),(2089,89,2),(2090,89,4),(2091,89,6),(2092,89,7),(2093,89,9),(2094,89,11),(2095,89,16),(2096,89,14),(2097,89,12),(2098,89,17),(2099,89,20),(2100,90,2),(2101,90,3),(2102,90,4),(2103,90,6),(2104,90,14),(2105,90,15),(2106,90,17),(2107,90,21),(2108,90,19),(2109,90,9),(2110,90,7),(2111,91,4),(2112,91,1),(2113,91,17),(2114,91,19),(2115,91,20),(2116,91,12),(2117,91,13),(2118,91,15),(2119,91,18),(2120,91,9),(2121,91,7),(2122,92,3),(2123,92,4),(2124,92,6),(2125,92,7),(2126,92,9),(2127,92,17),(2128,92,19),(2129,92,21),(2130,92,22),(2131,92,20),(2132,92,18),(2133,93,2),(2134,93,4),(2135,93,12),(2136,93,13),(2137,93,14),(2138,93,15),(2139,93,17),(2140,93,18),(2141,93,6),(2142,93,7),(2143,93,9),(2144,94,2),(2145,94,3),(2146,94,4),(2147,94,5),(2148,94,6),(2149,94,7),(2150,94,8),(2151,94,9),(2152,94,10),(2153,94,13),(2154,94,14),(2155,95,14),(2156,95,15),(2157,95,17),(2158,95,19),(2159,95,5),(2160,95,3),(2161,95,7),(2162,95,10),(2163,95,11),(2164,95,9),(2165,95,8),(2166,96,3),(2167,96,5),(2168,96,7),(2169,96,8),(2170,96,14),(2171,96,15),(2172,96,16),(2173,96,17),(2174,96,21),(2175,96,20),(2176,96,19),(2177,97,2),(2178,97,4),(2179,97,6),(2180,97,13),(2181,97,16),(2182,97,20),(2183,97,14),(2184,97,18),(2185,97,17),(2186,97,15),(2187,97,22),(2188,98,3),(2189,98,5),(2190,98,7),(2191,98,8),(2192,98,14),(2193,98,16),(2194,98,17),(2195,98,19),(2196,98,20),(2197,98,21),(2198,98,6),(2199,99,1),(2200,99,12),(2201,99,13),(2202,99,14),(2203,99,15),(2204,99,16),(2205,99,17),(2206,99,2),(2207,99,5),(2208,99,6),(2209,99,8),(2210,100,2),(2211,100,3),(2212,100,4),(2213,100,6),(2214,100,7),(2215,100,8),(2216,100,9),(2217,100,14),(2218,100,16),(2219,100,17),(2220,100,18),(2221,101,2),(2222,101,4),(2223,101,6),(2224,101,14),(2225,101,17),(2226,101,19),(2227,101,20),(2228,101,22),(2229,101,21),(2230,101,18),(2231,101,16),(2232,102,7),(2233,102,4),(2234,102,5),(2235,102,15),(2236,102,17),(2237,102,18),(2238,102,19),(2239,102,20),(2240,102,21),(2241,102,22),(2242,102,16),(2243,103,2),(2244,103,3),(2245,103,5),(2246,103,6),(2247,103,7),(2248,103,8),(2249,103,9),(2250,103,10),(2251,103,11),(2252,103,17),(2253,103,15),(2254,104,1),(2255,104,2),(2256,104,13),(2257,104,14),(2258,104,15),(2259,104,16),(2260,104,17),(2261,104,18),(2262,104,19),(2263,104,21),(2264,104,22),(2265,105,3),(2266,105,2),(2267,105,6),(2268,105,8),(2269,105,9),(2270,105,17),(2271,105,19),(2272,105,21),(2273,105,22),(2274,105,16),(2275,105,13),(2276,106,5),(2277,106,15),(2278,106,17),(2279,106,20),(2280,106,21),(2281,106,6),(2282,106,2),(2283,106,3),(2284,106,1),(2285,106,10),(2286,106,8),(2287,107,3),(2288,107,5),(2289,107,6),(2290,107,7),(2291,107,14),(2292,107,16),(2293,107,17),(2294,107,18),(2295,107,19),(2296,107,20),(2297,107,2),(2298,108,2),(2299,108,1),(2300,108,14),(2301,108,15),(2302,108,16),(2303,108,17),(2304,108,20),(2305,108,7),(2306,108,6),(2307,108,5),(2308,108,21),(2309,109,2),(2310,109,4),(2311,109,5),(2312,109,6),(2313,109,7),(2314,109,10),(2315,109,18),(2316,109,16),(2317,109,14),(2318,109,12),(2319,109,15),(2320,110,6),(2321,110,2),(2322,110,3),(2323,110,1),(2324,110,5),(2325,110,16),(2326,110,17),(2327,110,18),(2328,110,20),(2329,110,14),(2330,110,13),(2331,111,3),(2332,111,2),(2333,111,4),(2334,111,5),(2335,111,14),(2336,111,15),(2337,111,16),(2338,111,18),(2339,111,19),(2340,111,20),(2341,111,21),(2342,112,1),(2343,112,2),(2344,112,5),(2345,112,7),(2346,112,9),(2347,112,11),(2348,112,4),(2349,112,13),(2350,112,14),(2351,112,16),(2352,112,17),(2353,113,2),(2354,113,4),(2355,113,5),(2356,113,6),(2357,113,13),(2358,113,16),(2359,113,18),(2360,113,19),(2361,113,21),(2362,113,7),(2363,113,8),(2364,114,1),(2365,114,2),(2366,114,3),(2367,114,4),(2368,114,14),(2369,114,18),(2370,114,6),(2371,114,7),(2372,114,20),(2373,114,21),(2374,114,22),(2375,115,2),(2376,115,4),(2377,115,5),(2378,115,6),(2379,115,7),(2380,115,15),(2381,115,17),(2382,115,19),(2383,115,21),(2384,115,20),(2385,115,8),(2386,116,1),(2387,116,2),(2388,116,3),(2389,116,4),(2390,116,5),(2391,116,7),(2392,116,9),(2393,116,10),(2394,116,15),(2395,116,14),(2396,116,13),(2397,117,4),(2398,117,3),(2399,117,5),(2400,117,6),(2401,117,2),(2402,117,14),(2403,117,15),(2404,117,16),(2405,117,17),(2406,117,13),(2407,117,12),(2408,118,1),(2409,118,2),(2410,118,3),(2411,118,6),(2412,118,7),(2413,118,8),(2414,118,17),(2415,118,18),(2416,118,19),(2417,118,21),(2418,118,20),(2419,119,2),(2420,119,7),(2421,119,8),(2422,119,6),(2423,119,1),(2424,119,3),(2425,119,4),(2426,119,5),(2427,119,9),(2428,119,10),(2429,119,11),(2430,120,1),(2431,120,3),(2432,120,4),(2433,120,5),(2434,120,6),(2435,120,7),(2436,120,8),(2437,120,9),(2438,120,14),(2439,120,15),(2440,120,16),(2441,121,1),(2442,121,2),(2443,121,3),(2444,121,4),(2445,121,5),(2446,121,14),(2447,121,16),(2448,121,17),(2449,121,18),(2450,121,20),(2451,121,22),(2452,122,1),(2453,122,2),(2454,122,5),(2455,122,6),(2456,122,7),(2457,122,8),(2458,122,9),(2459,122,10),(2460,122,15),(2461,122,16),(2462,122,17),(2463,123,3),(2464,123,4),(2465,123,5),(2466,123,6),(2467,123,2),(2468,123,9),(2469,123,15),(2470,123,17),(2471,123,19),(2472,123,20),(2473,123,21),(2474,124,2),(2475,124,4),(2476,124,6),(2477,124,7),(2478,124,9),(2479,124,10),(2480,124,14),(2481,124,16),(2482,124,17),(2483,124,19),(2484,124,20),(2485,125,1),(2486,125,3),(2487,125,5),(2488,125,6),(2489,125,7),(2490,125,8),(2491,125,9),(2492,125,14),(2493,125,15),(2494,125,16),(2495,125,21),(2496,126,2),(2497,126,3),(2498,126,4),(2499,126,5),(2500,126,6),(2501,126,7),(2502,126,8),(2503,126,9),(2504,126,10),(2505,126,15),(2506,126,16),(2507,127,3),(2508,127,4),(2509,127,2),(2510,127,6),(2511,127,8),(2512,127,10),(2513,127,11),(2514,127,15),(2515,127,16),(2516,127,17),(2517,127,18),(2518,128,2),(2519,128,3),(2520,128,4),(2521,128,5),(2522,128,6),(2523,128,8),(2524,128,10),(2525,128,9),(2526,128,17),(2527,128,15),(2528,128,14),(2529,129,3),(2530,129,2),(2531,129,4),(2532,129,5),(2533,129,6),(2534,129,7),(2535,129,11),(2536,129,10),(2537,129,9),(2538,129,8),(2539,129,22),(2540,130,2),(2541,130,4),(2542,130,6),(2543,130,15),(2544,130,17),(2545,130,20),(2546,130,22),(2547,130,14),(2548,130,13),(2549,130,16),(2550,130,18),(2551,131,2),(2552,131,3),(2553,131,5),(2554,131,6),(2555,131,7),(2556,131,8),(2557,131,9),(2558,131,10),(2559,131,14),(2560,131,15),(2561,131,17),(2562,132,2),(2563,132,5),(2564,132,6),(2565,132,7),(2566,132,10),(2567,132,8),(2568,132,9),(2569,132,16),(2570,132,17),(2571,132,19),(2572,132,20),(2573,133,6),(2574,133,4),(2575,133,7),(2576,133,10),(2577,133,8),(2578,133,3),(2579,133,2),(2580,133,14),(2581,133,15),(2582,133,17),(2583,133,19),(2584,134,1),(2585,134,3),(2586,134,4),(2587,134,5),(2588,134,6),(2589,134,7),(2590,134,8),(2591,134,9),(2592,134,13),(2593,134,15),(2594,134,16),(2595,135,1),(2596,135,3),(2597,135,5),(2598,135,6),(2599,135,7),(2600,135,9),(2601,135,10),(2602,135,11),(2603,135,13),(2604,135,14),(2605,135,15),(2606,136,3),(2607,136,5),(2608,136,6),(2609,136,8),(2610,136,13),(2611,136,14),(2612,136,15),(2613,136,16),(2614,136,17),(2615,136,18),(2616,136,19),(2617,137,2),(2618,137,4),(2619,137,6),(2620,137,8),(2621,137,11),(2622,137,14),(2623,137,16),(2624,137,17),(2625,137,19),(2626,137,9),(2627,137,7),(2628,138,2),(2629,138,1),(2630,138,3),(2631,138,4),(2632,138,5),(2633,138,7),(2634,138,9),(2635,138,15),(2636,138,16),(2637,138,17),(2638,138,18),(2639,139,4),(2640,139,7),(2641,139,10),(2642,139,2),(2643,139,3),(2644,139,9),(2645,139,12),(2646,139,14),(2647,139,18),(2648,139,21),(2649,139,15),(2650,140,1),(2651,140,2),(2652,140,3),(2653,140,5),(2654,140,9),(2655,140,14),(2656,140,16),(2657,140,19),(2658,140,6),(2659,140,22),(2660,140,21),(2661,141,2),(2662,141,4),(2663,141,5),(2664,141,6),(2665,141,9),(2666,141,10),(2667,141,13),(2668,141,14),(2669,141,15),(2670,141,17),(2671,141,19),(2672,142,2),(2673,142,1),(2674,142,4),(2675,142,5),(2676,142,6),(2677,142,3),(2678,142,17),(2679,142,14),(2680,142,13),(2681,142,19),(2682,142,22),(2683,143,1),(2684,143,2),(2685,143,10),(2686,143,8),(2687,143,9),(2688,143,7),(2689,143,6),(2690,143,5),(2691,143,11),(2692,143,19),(2693,143,20),(2694,144,3),(2695,144,6),(2696,144,9),(2697,144,10),(2698,144,14),(2699,144,16),(2700,144,18),(2701,144,19),(2702,144,17),(2703,144,12),(2704,144,21),(2705,145,5),(2706,145,3),(2707,145,6),(2708,145,9),(2709,145,14),(2710,145,18),(2711,145,16),(2712,145,15),(2713,145,17),(2714,145,22),(2715,145,21),(2716,146,1),(2717,146,3),(2718,146,6),(2719,146,14),(2720,146,17),(2721,146,19),(2722,146,20),(2723,146,11),(2724,146,9),(2725,146,8),(2726,146,22),(2727,147,2),(2728,147,3),(2729,147,5),(2730,147,6),(2731,147,8),(2732,147,14),(2733,147,17),(2734,147,19),(2735,147,20),(2736,147,15),(2737,147,13),(2738,148,2),(2739,148,4),(2740,148,6),(2741,148,7),(2742,148,9),(2743,148,14),(2744,148,15),(2745,148,17),(2746,148,18),(2747,148,19),(2748,148,20),(2749,149,1),(2750,149,2),(2751,149,3),(2752,149,14),(2753,149,17),(2754,149,18),(2755,149,19),(2756,149,11),(2757,149,8),(2758,149,6),(2759,149,7),(2760,150,3),(2761,150,6),(2762,150,9),(2763,150,20),(2764,150,16),(2765,150,14),(2766,150,8),(2767,150,2),(2768,150,13),(2769,150,17),(2770,150,18),(2771,151,1),(2772,151,3),(2773,151,4),(2774,151,6),(2775,151,8),(2776,151,10),(2777,151,15),(2778,151,17),(2779,151,18),(2780,151,20),(2781,151,21),(2782,152,1),(2783,152,4),(2784,152,5),(2785,152,6),(2786,152,7),(2787,152,8),(2788,152,9),(2789,152,14),(2790,152,16),(2791,152,18),(2792,152,19),(2793,153,5),(2794,153,3),(2795,153,6),(2796,153,8),(2797,153,9),(2798,153,10),(2799,153,1),(2800,153,15),(2801,153,14),(2802,153,18),(2803,153,20),(2804,154,3),(2805,154,5),(2806,154,7),(2807,154,2),(2808,154,10),(2809,154,15),(2810,154,17),(2811,154,19),(2812,154,20),(2813,154,14),(2814,154,13),(2815,155,1),(2816,155,4),(2817,155,6),(2818,155,8),(2819,155,10),(2820,155,11),(2821,155,14),(2822,155,15),(2823,155,18),(2824,155,19),(2825,155,13),(2826,156,2),(2827,156,4),(2828,156,6),(2829,156,8),(2830,156,10),(2831,156,15),(2832,156,16),(2833,156,17),(2834,156,18),(2835,156,20),(2836,156,21),(2837,157,1),(2838,157,3),(2839,157,5),(2840,157,7),(2841,157,8),(2842,157,14),(2843,157,15),(2844,157,16),(2845,157,17),(2846,157,20),(2847,157,21);
/*!40000 ALTER TABLE `team_has_players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Yoga Ranjan Singh',26,'yogaranjansingh','password'),(2,'ankita',25,'ankitasharma','navyaelite'),(4,'gopi',30,'gopi007','sms'),(5,'aishwarya',25,'kaishu',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_matches`
--

DROP TABLE IF EXISTS `user_has_matches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_has_matches` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `matchId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_matches`
--

LOCK TABLES `user_has_matches` WRITE;
/*!40000 ALTER TABLE `user_has_matches` DISABLE KEYS */;
INSERT INTO `user_has_matches` VALUES (1,1,1),(2,2,NULL);
/*!40000 ALTER TABLE `user_has_matches` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-30  9:41:12
