
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object displayTable extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[Run],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(runs:List[Run]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.18*/("""


"""),_display_(Seq[Any](/*4.2*/homeSkeleton/*4.14*/	{_display_(Seq[Any](format.raw/*4.16*/("""
<!DOCTYPE html>
  <html>
  <style>
p
"""),format.raw/*9.1*/("""{"""),format.raw/*9.2*/("""

"""),format.raw/*11.1*/("""}"""),format.raw/*11.2*/("""
p.padding
"""),format.raw/*13.1*/("""{"""),format.raw/*13.2*/("""
padding-top:25px;
padding-bottom:25px;
padding-right:50px;
padding-left:50px;
"""),format.raw/*18.1*/("""}"""),format.raw/*18.2*/("""
</style>
<head>
	<meta charset="utf-8">
	<script type="text/javascript" src=""""),_display_(Seq[Any](/*22.39*/routes/*22.45*/.Application.javascriptRoutes())),format.raw/*22.76*/(""""></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href=""""),_display_(Seq[Any](/*24.48*/routes/*24.54*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*24.97*/("""">
	<script type="text/javascript" src=""""),_display_(Seq[Any](/*25.39*/routes/*25.45*/.Assets.at("js/jquery.chained.min.js"))),format.raw/*25.83*/("""" charset="utf-8"></script>
	<script type="text/javascript" src=""""),_display_(Seq[Any](/*26.39*/routes/*26.45*/.Application.javascriptRoutes())),format.raw/*26.76*/(""""></script>
</head>
   
<body>
	<h1>Display Table</h1>
	<br>
	<table border="1">
	<tr>
	"""),_display_(Seq[Any](/*34.3*/{
	var str = "";
	var i = 0;
	for (i <- 0 to 3)	{
		str += "<td>" + runs(i).name + "</td>"
	}
	Html(str)
	})),format.raw/*41.3*/("""
	</tr>
	</table>
	
</body>
</html>
""")))})),format.raw/*47.2*/("""
"""))}
    }
    
    def render(runs:List[Run]): play.api.templates.Html = apply(runs)
    
    def f:((List[Run]) => play.api.templates.Html) = (runs) => apply(runs)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Feb 12 14:10:17 EST 2014
                    SOURCE: C:/Users/dhallahan/workspace/regressionsiteRnd2-1/eclipse-regressionsite/app/views/displayTable.scala.html
                    HASH: 209089d9a4676a8cb37f1c6cdfe401a47a9ef499
                    MATRIX: 733->1|826->17|867->24|887->36|926->38|995->81|1022->82|1053->86|1081->87|1121->100|1149->101|1260->185|1288->186|1407->269|1422->275|1475->306|1663->458|1678->464|1743->507|1821->549|1836->555|1896->593|1999->660|2014->666|2067->697|2199->794|2334->908|2408->951
                    LINES: 26->1|29->1|32->4|32->4|32->4|37->9|37->9|39->11|39->11|41->13|41->13|46->18|46->18|50->22|50->22|50->22|52->24|52->24|52->24|53->25|53->25|53->25|54->26|54->26|54->26|62->34|69->41|75->47
                    -- GENERATED --
                */
            