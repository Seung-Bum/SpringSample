DAO.DTO // Association & collection Mapping
-------------

![Alt text](img.jpg)

JSON DATA 형식 검사 <br>
https://jsonformatter.curiousconcept.com/#

<br>

```
   
   Mapping 용어
   
   mybatis의 인터페이스
   2. 컨트롤러 -> 서비스 -> DAO(Mapper) -> DB


   DAO 대신 Mapper 사용
   매퍼를 사용하면 일일히 DAO를 만들지 않고 인터페이스만을 이용해서 좀 더 편하게 개발할 수 있습니다.


    namespace
    : Mapper의 전체 경로를 적습니다.


    id
    : 매퍼 인터페이스와 XML파일을 매칭 시키기 위해서 매퍼 인터페이스의 메소드 명과 XML 파일의 id를 동일하게 작성해줘야 합니다.


    resultType
    : SQL문을 실행하고 결과값을 어떤 형식으로 반환할지를 나타냅니다. 여기서는 BoardDto 객체로 반환합니다.
    import를 못쓰기 때문에 풀로 다 적어줘야한다. (application.propersies에 적어야함)

```
<br>

* DTO를 사용하는 경우와 사용하지 않는 경우 <br>

DTO를 사용하는 경우의 XML Mapping
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="co.kr.mono.studydb.dao.AreaSalesDao">
    <select id="findAreaSales" parameterType="String" resultType="AreaSalesDTO">
        SELECT AREA_CD AREACD
            ,REGION_AREA REGIONAREA
            ,PROD_ID PRODID
            ,SUM(SALE_CNT) SALECNT
        FROM SALE_TBL
        WHERE AREA_CD = #{areaCd}
        AND ROWNUM = 1
        GROUP BY AREA_CD
        ,REGION_AREA
        ,PROD_ID
    </select>

    <select id="findAreaSalesMap" parameterType="String" resultType="map"> <!-- 미리 MyBatise에 적혀있다 별칭 -->
            SELECT AREA_CD AREACD
                ,REGION_AREA REGIONAREA
                ,PROD_ID PRODID
                ,SUM(SALE_CNT) SALECNT
            FROM SALE_TBL
            WHERE AREA_CD = #{areaCd}
                AND ROWNUM = 1
            GROUP BY AREA_CD
                ,REGION_AREA
                ,PROD_ID
    </select>

    <select id="findMsaleByMultiParm" parameterType="map" resultType="map">
        SELECT PRODID
              ,PRODNM
              ,SALECNT
        FROM MSALES
        WHERE PRODID like #{prodId}||'%'
          AND PRODID like #{prodNm}||'%'
          AND ROWNUM = 1
    </select>

    <select id="findMsaleByMultiReturn" parameterType="map" resultType="map">
        SELECT PRODID
        ,PRODNM
        ,SALECNT
        FROM MSALES
        WHERE PRODID like #{prodId}||'%'
        AND  PRODNM like #{prodNm}||'%'
    </select>

</mapper>
```


DTO를 사용하지 않는 경우 <br> 
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="co.kr.mono.studydb.dao.MusicJoinDao">

    <!-- 앨범 기준 : 아티스트 정보를 입력받아 아티스트의 앨범을 가져온다. -->
    <resultMap id="selectArtistAlbumMap" type="co.kr.mono.studydb.model.music.Album" >
        <id column="album_Id" property="albumId" jdbcType="VARCHAR"/>
        <result column="album_seq" property="albumSeq" jdbcType="INTEGER"/>
        <result column="album_title" property="albumTitle" jdbcType="VARCHAR"/>
        <result column="open_date" property="openDate" jdbcType="VARCHAR"/>
        <!-- 앨범 기준 : 아티스트 1 : 앨범 : N -->
        <association column="mst_id" property="artist" javaType="co.kr.mono.studydb.model.music.Artist" >
            <id column="mst_id" property="mstId" jdbcType="VARCHAR"/>
            <result column="mst_name" property="mstName" jdbcType="VARCHAR"/>
            <result column="debut_date" property="debutDate" jdbcType="VARCHAR"/>
        </association>
    </resultMap>

    <!-- 아티스트 테이블과 앨범 테이블 조인 => 앨범ID로 검색, 앨범 정보와 아티스트 정보-->
    <select id="selectArtistByPrimaryKey1" resultMap="selectArtistAlbumMap" parameterType="java.lang.String">
        SELECT A.MST_ID        MST_ID
              ,A.MST_NAME     MST_NAME
              ,A.DEBUT_DATE   DEBUT_DATE
              ,B.ALBUM_ID     ALBUM_ID
              ,B.ALBUM_SEQ    ALBUM_SEQ
              ,B.ALBUM_TITLE  ALBUM_TITLE
              ,B.OPEN_DATE    OPEN_DATE
        FROM ARTIST A,ALBUM B
        WHERE A.MST_ID = B.MST_ID
        AND B.MST_ID =#{mst_id,jdbcType=VARCHAR}
    </select>

    <!-- 아티스트 기준으로 앨범정보랑 조인해서 정보 가져오기 -->
    <resultMap id="selectArtistPkAlbumMap" type="co.kr.mono.studydb.model.music.Artist" >
        <id column="mst_id" property="mstId" jdbcType="VARCHAR"/>
        <result column="mst_name" property="mstName" jdbcType="VARCHAR"/>
        <result column="debut_date" property="debutDate" jdbcType="VARCHAR"/>
        <!-- 아티스트 기준 : 아티스트 1 : 앨범 : N -->
        <collection column="mst_id" property="album" javaType="java.util.ArrayList" ofType="co.kr.mono.studydb.model.music.Album" >
            <id column="album_Id" property="albumId" jdbcType="VARCHAR"/>
            <result column="album_seq" property="albumSeq" jdbcType="INTEGER"/>
            <result column="album_title" property="albumTitle" jdbcType="VARCHAR"/>
            <result column="open_date" property="openDate" jdbcType="VARCHAR"/>
        </collection>
    </resultMap>

    <!-- 아티스트 테이블과 앨범 테이블 조인 => 앨범ID로 검색, 앨범 정보와 아티스트 정보-->
    <select id="selectArtistByPrimaryKey2" resultMap="selectArtistPkAlbumMap" parameterType="java.lang.String">
        SELECT A.MST_ID        MST_ID
        ,A.MST_NAME     MST_NAME
        ,A.DEBUT_DATE   DEBUT_DATE
        ,B.ALBUM_ID     ALBUM_ID
        ,B.ALBUM_SEQ    ALBUM_SEQ
        ,B.ALBUM_TITLE  ALBUM_TITLE
        ,B.OPEN_DATE    OPEN_DATE
        FROM ARTIST A,ALBUM B
        WHERE A.MST_ID = B.MST_ID
        AND A.MST_ID =#{mst_id,jdbcType=VARCHAR}
    </select>

    <!-- 앨범기준 : 앨범 테이블과 노래 테이블 조인해서 정보 가져오기 -->
    <resultMap id="albumSongResultMap" type="co.kr.mono.studydb.model.music.Album" >
        <id column="album_Id" property="albumId" jdbcType="VARCHAR"/>
        <result column="album_seq" property="albumSeq" jdbcType="INTEGER"/>
        <result column="album_title" property="albumTitle" jdbcType="VARCHAR"/>
        <result column="open_date" property="openDate" jdbcType="VARCHAR"/>
        <!-- 앨범기준 : 앨범 1 : 노래 : N -->
        <collection column="album_Id" property="songs" javaType="java.util.ArrayList" ofType="co.kr.mono.studydb.model.music.Song">
            <id column="album_id" property="albumId" jdbcType="VARCHAR"/>
            <id column="song_name" property="songName" jdbcType="VARCHAR"/>
            <result column="play_time" property="playTime" jdbcType="BIGINT"/>
        </collection>
    </resultMap>

    <select id="selectAlbumByPrimaryKey1" resultMap="albumSongResultMap" parameterType="java.lang.String">
        SELECT A.ALBUM_ID     ALBUM_ID
        ,A.MST_ID      MST_ID
        ,A.ALBUM_SEQ   ALBUM_SEQ
        ,A.OPEN_DATE   OPEN_DATE
        ,B.SONG_NAME   SONG_NAME
        ,B.PLAY_TIME   PLAY_TIME
        FROM ALBUM A,SONG B
        WHERE A.ALBUM_ID = B.ALBUM_ID
        AND   A.ALBUM_ID =#{album_id,jdbcType=VARCHAR}
    </select>

    <!-- 앨범기준 : 앨범, 노래, 아티스트 테이블 모두 조인 -->
    <resultMap id="artistAlbumSongMap" type="co.kr.mono.studydb.model.music.Album" >
        <id column="album_Id" property="albumId" jdbcType="VARCHAR"/>
        <result column="album_seq" property="albumSeq" jdbcType="INTEGER"/>
        <result column="album_title" property="albumTitle" jdbcType="VARCHAR"/>
        <result column="open_date" property="openDate" jdbcType="VARCHAR"/>
        <association column="mst_id" property="artist" javaType="co.kr.mono.studydb.model.music.Artist" >
            <id column="mst_id" property="mstId" jdbcType="VARCHAR"/>
            <result column="mst_name" property="mstName" jdbcType="VARCHAR"/>
            <result column="debut_date" property="debutDate" jdbcType="VARCHAR"/>
        </association>
        <collection column="album_Id" property="songs" javaType="java.util.ArrayList" ofType="co.kr.mono.studydb.model.music.Song">
            <id column="album_id" property="albumId" jdbcType="VARCHAR"/>
            <id column="song_name" property="songName" jdbcType="VARCHAR"/>
            <result column="play_time" property="playTime" jdbcType="FLOAT"/>
        </collection>
    </resultMap>

    <select id="selectAlbumByPrimaryKey2" resultMap="artistAlbumSongMap" parameterType="java.lang.String">
        SELECT A.MST_ID        MST_ID
            ,A.MST_NAME     MST_NAME
            ,A.DEBUT_DATE   DEBUT_DATE
            ,B.ALBUM_ID     ALBUM_ID
            ,B.ALBUM_SEQ    ALBUM_SEQ
            ,B.ALBUM_TITLE  ALBUM_TITLE
            ,B.OPEN_DATE    OPEN_DATE
            ,C.SONG_NAME    SONG_NAME
            ,C.PLAY_TIME    PLAY_TIME
        FROM ARTIST A,ALBUM B,SONG C
        WHERE A.MST_ID = B.MST_ID
        AND B.ALBUM_ID = C.ALBUM_ID
        AND B.ALBUM_ID = #{alubm_id,jdbcType=VARCHAR}
    </select>
</mapper>

```
