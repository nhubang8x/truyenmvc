package com.apt.truyenmvc.utils;

import org.springframework.stereotype.Component;

/**
 * @author Huy Thang
 *
 */

public class ConstansQueryUtils {

	public static final String STORY_NEW_UPDATE = "SELECT s.sID, s.vnName, s.sImages, s.sAuthor, s.sMetaTitle, s.sUpdate, c.chID, c.chNumber, u.uName, u.uDname"
			+ " FROM Story s LEFT JOIN (SELECT c.* FROM Chapter c INNER JOIN"
			+ " (SELECT MAX(c.chID) AS chapterID FROM Story s"
			+ " LEFT JOIN Chapter c"
			+ " ON s.sID = c.sID GROUP BY s.sID) d"
			+ " ON c.chID = d.chapterID "
			+ " WHERE c.chStatus = :chStatus) c "
			+ " ON s.sID = c.sID "
			+ " LEFT JOIN user u on c.uID = u.uID"
			+ " WHERE s.sStatus IN :sStatus" 
			+ " ORDER BY s.sUpdate DESC";

    public static final String COUNT_STORY_NEW_UPDATE = "SELECT COUNT(*)"
            + " FROM Story s LEFT JOIN (SELECT c.* FROM Chapter c INNER JOIN"
            + " (SELECT MAX(c.chID) AS chapterID FROM Story s"
            + " LEFT JOIN Chapter c"
            + " ON s.sID = c.sID GROUP BY s.sID) d"
            + " ON c.chID = d.chapterID "
            + " WHERE c.chStatus = :chStatus) c "
            + " ON s.sID = c.sID "
            + " LEFT JOIN user u on c.uID = u.uID"
            + " WHERE s.sStatus IN :sStatus"
            + " ORDER BY s.sUpdate DESC";

	public static final String STORY_NEW_UPDATE_BY_CATEGORY = "SELECT s.sID, s.vnName, s.sImages, s.sAuthor, s.sMetaTitle, s.sUpdate, c.chID, c.chNumber, u.uName, u.uDname"
			+ " FROM Story s LEFT JOIN (SELECT c.* FROM Chapter c INNER JOIN"
			+ " (SELECT MAX(c.chID) AS chapterID FROM Story s"
			+ " LEFT JOIN Chapter c"
			+ " ON s.sID = c.sID GROUP BY s.sID) d"
			+ " ON c.chID = d.chapterID "
			+ " WHERE c.chStatus = :chStatus) c "
			+ " ON s.sID = c.sID "
			+ " LEFT JOIN user u on c.uID = u.uID"
			+ " LEFT JOIN `_scategory` sc on s.sID = sc.sID"
			+ " WHERE  sc.cID = :cID AND s.sStatus IN :sStatus" 
			+ " ORDER BY s.sUpdate DESC";

    public static final String COUNT_STORY_NEW_UPDATE_BY_CATEGORY = "SELECT COUNT(*)"
            + " FROM Story s LEFT JOIN (SELECT c.* FROM Chapter c INNER JOIN"
            + " (SELECT MAX(c.chID) AS chapterID FROM Story s"
            + " LEFT JOIN Chapter c"
            + " ON s.sID = c.sID GROUP BY s.sID) d"
            + " ON c.chID = d.chapterID "
            + " WHERE c.chStatus = :chStatus) c "
            + " ON s.sID = c.sID "
            + " LEFT JOIN user u on c.uID = u.uID"
            + " LEFT JOIN `_scategory` sc on s.sID = sc.sID"
            + " WHERE  sc.cID = :cID AND s.sStatus IN :sStatus"
            + " ORDER BY s.sUpdate DESC";

    public static final String VIP_STORY_NEW_UPDATE = "SELECT s.sID, s.vnName, s.sImages, s.sAuthor, s.sMetaTitle, s.sUpdate, c.chID, c.chNumber, u.uName, u.uDname"
            + " FROM Story s LEFT JOIN (SELECT c.* FROM Chapter c INNER JOIN"
            + " (SELECT MAX(c.chID) AS chapterID FROM Story s"
            + " LEFT JOIN Chapter c"
            + " ON s.sID = c.sID GROUP BY s.sID) d"
            + " ON c.chID = d.chapterID "
            + " WHERE c.chStatus = :chStatus) c "
            + " ON s.sID = c.sID "
            + " LEFT JOIN user u on c.uID = u.uID"
            + " WHERE s.sStatus IN :sStatus AND sDealStatus = :sDealStatus"
            + " ORDER BY s.sUpdate DESC";

    public static final String COUNT_VIP_STORY_NEW_UPDATE = "SELECT COUNT(*)"
            + " FROM Story s LEFT JOIN (SELECT c.* FROM Chapter c INNER JOIN"
            + " (SELECT MAX(c.chID) AS chapterID FROM Story s"
            + " LEFT JOIN Chapter c"
            + " ON s.sID = c.sID GROUP BY s.sID) d"
            + " ON c.chID = d.chapterID "
            + " WHERE c.chStatus = :chStatus) c "
            + " ON s.sID = c.sID "
            + " LEFT JOIN user u on c.uID = u.uID"
            + " WHERE s.sStatus IN :sStatus AND sDealStatus = :sDealStatus"
            + " ORDER BY s.sUpdate DESC";
	
	public static final String STORY_TOP_VIEW = "SELECT s.sID, s.vnName, s.sImages, s.sAuthor, s.sMetaTitle, COALESCE(d.countView,0) AS cnt, ca.cID, ca.cName FROM Story s"
			+ " LEFT JOIN (SELECT c.sID, COUNT(c.sID) AS countView FROM Chapter c"
			+ " LEFT JOIN `_ufavorites` u ON  c.chID = u.chID"
			+ " LEFT JOIN Story st on c.sID = st.sID"
			+ " WHERE st.sStatus IN :sStatus"
			+ " AND u.dateView BETWEEN :startDate AND :endDate"
			+ " GROUP BY c.sID) d ON s.sID = d.sID"
			+ " LEFT JOIN `_scategory` sc on s.sID = sc.sID"
			+ " LEFT JOIN Category ca on sc.cID = ca.cID"
			+ " WHERE  s.sStatus IN :sStatus"
			+ " GROUP BY ca.cID"
			+ " ORDER BY cnt DESC, s.sView DESC";

	public static final String COUNT_STORY_TOP_VIEW = "SELECT COUNT(*) FROM (SELECT s.sID, COALESCE(d.countView,0) AS cnt FROM Story s"
			+ " LEFT JOIN (SELECT c.sID, COUNT(c.sID) AS countView FROM Chapter c"
			+ " LEFT JOIN `_ufavorites` u ON  c.chID = u.chID"
			+ " LEFT JOIN Story st on c.sID = st.sID"
			+ " WHERE st.sStatus IN :sStatus"
			+ " AND u.dateView BETWEEN :startDate AND :endDate"
			+ " GROUP BY c.sID) d ON s.sID = d.sID"
			+ " LEFT JOIN `_scategory` sc on s.sID = sc.sID"
			+ " LEFT JOIN Category ca on sc.cID = ca.cID"
			+ " WHERE  s.sStatus IN :sStatus"
			+ " GROUP BY ca.cID"
			+ " ORDER BY cnt DESC, s.sView DESC) rs";
	
	public static final String STORY_TOP_VIEW_BY_CATEGORY = "SELECT s.sID, s.vnName, s.sImages, s.sAuthor, s.sMetaTitle, COALESCE(d.countView,0) AS cnt, ca.cID, ca.cName FROM Story s"
			+ " LEFT JOIN (SELECT c.sID, COUNT(c.sID) AS countView FROM Chapter c"
			+ " LEFT JOIN `_ufavorites` u ON  c.chID = u.chID"
			+ " LEFT JOIN Story st on c.sID = st.sID"
			+ " WHERE st.sStatus IN :sStatus"
			+ " AND u.dateView BETWEEN :startDate AND :endDate"
			+ " GROUP BY c.sID) d ON s.sID = d.sID"
			+ " LEFT JOIN `_scategory` sc on s.sID = sc.sID"
			+ " LEFT JOIN Category ca on sc.cID = ca.cID"
			+ " WHERE  s.sStatus IN :sStatus AND sc.cID = :cID"
			+ " ORDER BY cnt DESC, s.sView DESC";

	public static final String COUNT_STORY_TOP_VIEW_BY_CATEGORY = "SELECT COUNT(*) FROM (SELECT s.sID, COALESCE(d.countView,0) AS cnt FROM Story s"
			+ " LEFT JOIN (SELECT c.sID, COUNT(c.sID) AS countView FROM Chapter c"
			+ " LEFT JOIN `_ufavorites` u ON  c.chID = u.chID"
			+ " LEFT JOIN Story st on c.sID = st.sID"
			+ " WHERE st.sStatus IN :sStatus"
			+ " AND u.dateView BETWEEN :startDate AND :endDate"
			+ " GROUP BY c.sID) d ON s.sID = d.sID"
			+ " LEFT JOIN `_scategory` sc on s.sID = sc.sID"
			+ " LEFT JOIN Category ca on sc.cID = ca.cID"
			+ " WHERE  s.sStatus IN :sStatus AND sc.cID = :cID"
			+ " ORDER BY cnt DESC, s.sView DESC) rs";
	
	public static final String STORY_VIP_TOP_VIEW = "SELECT s.sID, s.vnName, s.sImages, s.sAuthor, s.sMetaTitle, g.cnt FROM Story s"
			+ " LEFT JOIN (SELECT  c.sID, c.chID,SUM(ch.price) AS cnt FROM Chapter c"
			+ " LEFT JOIN `_chdeal` ch on c.chID = ch.chID"
			+ " WHERE ch.createDate BETWEEN :startDate AND :endDate"
			+ " GROUP BY c.sID) g ON g.sID = s.sID"
			+ " WHERE s.sDealStatus = :sDealStatus AND s.sStatus IN :sStatus"
			+ " ORDER BY g.cnt DESC";

	public static final String COUNT_STORY_VIP_TOP_VIEW = "SELECT COUNT(*) FROM Story s"
			+ " LEFT JOIN (SELECT  c.sID, c.chID,SUM(ch.price) AS cnt FROM Chapter c"
			+ " LEFT JOIN `_chdeal` ch on c.chID = ch.chID"
			+ " WHERE ch.createDate BETWEEN :startDate AND :endDate"
			+ " GROUP BY c.sID) g ON g.sID = s.sID"
			+ " WHERE s.sDealStatus = :sDealStatus AND s.sStatus IN :sStatus"
			+ " ORDER BY g.cnt DESC";
	
	public static final String TOP_CONVERTER = "SELECT u.uID, u.uName, u.uDname, u.uAvatar, COALESCE(d.cnt ,0) AS con FROM User u"
			+ " LEFT JOIN (SELECT c.uID,COUNT(c.uID) as cnt FROM Chapter c"
			+ " WHERE c.chStatus = :chStatus"
	        + " GROUP BY c.uID) d ON u.uID = d.uID"
			+ " WHERE u.uStatus = :uStatus"
			+ " ORDER BY con DESC";
	
	public static final String COUNT_TOP_CONVERTER = "SELECT COUNT(*) FROM User u"
			+ " LEFT JOIN (SELECT c.uID,COUNT(c.uID) as cnt FROM Chapter c"
			+ " WHERE c.chStatus = :chStatus"
	        + " GROUP BY c.uID) d ON u.uID = d.uID"
			+ " WHERE u.uStatus = :uStatus"
			+ " ORDER BY d.cnt DESC";

	public static final String LIST_ALL_FAVORITES_CHAPTER ="SELECT c.* FROM Chapter c"
            + " INNER JOIN (SELECT MAX(uf.ufID), uf.chID FROM `_ufavorites` uf"
            + " LEFT JOIN Chapter c ON uf.chID = c.chID"
            + " WHERE uf.uID= :uID AND uf.ufStatus = :ufStatus AND c.chStatus = :chStatus"
            + " GROUP BY c.sID) d ON d.chID = c.chID"
            + " INNER JOIN Story s on c.sID = s.sID"
            + " WHERE S.sStatus != :sStatus"
            + " ORDER BY s.sUpdate DESC";

    public static final String STORY_COMPLETE= "SELECT s.sID, s.vnName, s.sImages, s.sAuthor, s.sMetaTitle, s.sUpdate, c.chID, c.chNumber, u.uName, u.uDname"
            + " FROM Story s LEFT JOIN (SELECT c.* FROM Chapter c INNER JOIN"
            + " (SELECT MAX(c.chID) AS chapterID FROM Story s"
            + " LEFT JOIN Chapter c"
            + " ON s.sID = c.sID GROUP BY s.sID) d"
            + " ON c.chID = d.chapterID "
            + " WHERE c.chStatus = :chStatus) c "
            + " ON s.sID = c.sID "
            + " LEFT JOIN user u on c.uID = u.uID"
            + " WHERE s.sStatus = :sStatus"
            + " ORDER BY s.sUpdate DESC";

    public static final String COUNT_STORY_COMPLETE = "SELECT COUNT(*)"
            + " FROM Story s LEFT JOIN (SELECT c.* FROM Chapter c INNER JOIN"
            + " (SELECT MAX(c.chID) AS chapterID FROM Story s"
            + " LEFT JOIN Chapter c"
            + " ON s.sID = c.sID GROUP BY s.sID) d"
            + " ON c.chID = d.chapterID "
            + " WHERE c.chStatus = :chStatus) c "
            + " ON s.sID = c.sID "
            + " LEFT JOIN user u on c.uID = u.uID"
            + " WHERE s.sStatus = :sStatus"
            + " ORDER BY s.sUpdate DESC";

    public static final String COMPLETE_STORY_TOP_VIEW_SWAPPER = "SELECT s.* FROM Story s"
            + " LEFT JOIN (SELECT c.sID, COUNT(c.sID) AS countView FROM Chapter c"
            + " LEFT JOIN `_ufavorites` u ON  c.chID = u.chID"
            + " LEFT JOIN Story st on c.sID = st.sID"
            + " WHERE st.sStatus = :sStatus"
            + " AND u.dateView BETWEEN :startDate AND :endDate"
            + " GROUP BY c.sID) d ON s.sID = d.sID"
            + " WHERE  s.sStatus = :sStatus"
            + " ORDER BY COALESCE(d.countView,0) DESC, s.sView DESC";

    public static final String COUNT_COMPLETE_STORY_TOP_VIEW_SWAPPER = "SELECT COUNT(*) FROM (SELECT s.* FROM Story s"
            + " LEFT JOIN (SELECT c.sID, COUNT(c.sID) AS countView FROM Chapter c"
            + " LEFT JOIN `_ufavorites` u ON  c.chID = u.chID"
            + " LEFT JOIN Story st on c.sID = st.sID"
            + " WHERE st.sStatus = :sStatus"
            + " AND u.dateView BETWEEN :startDate AND :endDate"
            + " GROUP BY c.sID) d ON s.sID = d.sID"
            + " WHERE  s.sStatus = :sStatus"
            + " ORDER BY COALESCE(d.countView,0) DESC, s.sView DESC) rs";
}
