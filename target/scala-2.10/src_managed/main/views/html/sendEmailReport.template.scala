
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
object sendEmailReport extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[Run],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(runs:List[Run]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.18*/("""

"""),_display_(Seq[Any](/*3.2*/homeSkeleton/*3.14*/{_display_(Seq[Any](format.raw/*3.15*/("""
<!DOCTYPE html>
  <html>
  <style>
p
"""),format.raw/*8.1*/("""{"""),format.raw/*8.2*/("""

"""),format.raw/*10.1*/("""}"""),format.raw/*10.2*/("""
p.padding
"""),format.raw/*12.1*/("""{"""),format.raw/*12.2*/("""
padding-top:25px;
padding-bottom:25px;
padding-right:50px;
padding-left:50px;
"""),format.raw/*17.1*/("""}"""),format.raw/*17.2*/("""
h1, h2, h3, h4, h5, h6	"""),format.raw/*18.24*/("""{"""),format.raw/*18.25*/("""
	text-align: center;
"""),format.raw/*20.1*/("""}"""),format.raw/*20.2*/("""
</style>
<head>
	<meta charset="utf-8">
   <script type="text/javascript" src=""""),_display_(Seq[Any](/*24.41*/routes/*24.47*/.Application.javascriptRoutes())),format.raw/*24.78*/(""""></script>
   <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
   <link rel="stylesheet" type="text/css" href=""""),_display_(Seq[Any](/*26.50*/routes/*26.56*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*26.99*/("""">
   <script type="text/javascript" src=""""),_display_(Seq[Any](/*27.41*/routes/*27.47*/.Assets.at("js/jquery.chained.min.js"))),format.raw/*27.85*/("""" charset="utf-8"></script>
   <script type="text/javascript" src=""""),_display_(Seq[Any](/*28.41*/routes/*28.47*/.Application.javascriptRoutes())),format.raw/*28.78*/(""""></script>
</head>  

<body>   

   <h1>Email Reporting</h1>
   <br> 	
  	<select id='selectedRuns' size=25 multiple required>
		"""),_display_(Seq[Any](/*36.4*/for(run <- runs) yield /*36.20*/	{_display_(Seq[Any](format.raw/*36.22*/("""
  		<option value="""),_display_(Seq[Any](/*37.20*/run/*37.23*/.name)),format.raw/*37.28*/(""">"""),_display_(Seq[Any](/*37.30*/run/*37.33*/.name)),format.raw/*37.38*/("""</option>
  		""")))})),format.raw/*38.6*/("""
  	</select>
   <input type = "button" id = "submitRequest" value= "Submit Request" class="btn primary"
 		onclick = "submitRequest()"/>
 
 
  	
   <form id="reportingForm" action="./createemailreport" method="post">
		<input type="hidden" id="runSelection" name="runSelection" value="not set">
 	</form>
 </body>

<script>
function submitRequest()	"""),format.raw/*51.26*/("""{"""),format.raw/*51.27*/("""
	//read the runs dropdown
	var selected = $('#selectedRuns :selected');
	
	var runs = "";
	for(var i = 0; i < selected.length; i++)	"""),format.raw/*56.43*/("""{"""),format.raw/*56.44*/("""
		runs += selected[i].text + ", ";
	"""),format.raw/*58.2*/("""}"""),format.raw/*58.3*/("""
	runs = runs.slice(0, runs.length-2);
	alert(runs);
	$('#runSelection').val(runs);
	
	$('#reportingForm').submit();
"""),format.raw/*64.1*/("""}"""),format.raw/*64.2*/("""
</script>
""")))})))}
    }
    
    def render(runs:List[Run]): play.api.templates.Html = apply(runs)
    
    def f:((List[Run]) => play.api.templates.Html) = (runs) => apply(runs)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Feb 12 14:10:19 EST 2014
                    SOURCE: C:/Users/dhallahan/workspace/regressionsiteRnd2-1/eclipse-regressionsite/app/views/sendEmailReport.scala.html
                    HASH: acedcb1eaa1fb66c1e996fed8f3a0d714f6c263f
                    MATRIX: 736->1|829->17|868->22|888->34|926->35|995->78|1022->79|1053->83|1081->84|1121->97|1149->98|1260->182|1288->183|1341->208|1370->209|1421->233|1449->234|1570->319|1585->325|1638->356|1830->512|1845->518|1910->561|1990->605|2005->611|2065->649|2170->718|2185->724|2238->755|2412->894|2444->910|2484->912|2541->933|2553->936|2580->941|2618->943|2630->946|2657->951|2704->967|3095->1330|3124->1331|3290->1469|3319->1470|3385->1509|3413->1510|3563->1633|3591->1634
                    LINES: 26->1|29->1|31->3|31->3|31->3|36->8|36->8|38->10|38->10|40->12|40->12|45->17|45->17|46->18|46->18|48->20|48->20|52->24|52->24|52->24|54->26|54->26|54->26|55->27|55->27|55->27|56->28|56->28|56->28|64->36|64->36|64->36|65->37|65->37|65->37|65->37|65->37|65->37|66->38|79->51|79->51|84->56|84->56|86->58|86->58|92->64|92->64
                    -- GENERATED --
                */
            