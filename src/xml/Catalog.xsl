<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : Catalog.xsl
    Created on : November 4, 2015, 3:01 PM
    Author     : chungld-hanam
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>Bộ sưu tập</title>
            </head>
            <body>
                <table border="1">
                    <tr>
                        <th>Title</th>
                        <th>Artist</th>
                        <th>Country</th>
                        <th>Company</th>
                        <th>Price</th>
                        <th>Year</th>
                    </tr>
                    <xsl:for-each select="CATALOG/CD">
                        <tr>
                            <td>
                                <xsl:value-of select="concat(TITLE,ARTIST)"/>
                            </td>
                            <td>
                                <xsl:value-of select="ARTIST"/>
                            </td>
                             <td>
                                <xsl:value-of select="COUNTRY"/>
                            </td>
                             <td>
                                <xsl:value-of select="COMPANY"/>
                            </td>
                             <td>
                                <xsl:value-of select="PRICE"/>
                            </td>
                             <td>
                                <xsl:value-of select="YEAR"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
