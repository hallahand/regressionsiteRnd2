
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
object displayEmailRecipientInfo extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Email,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(email:Email):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.15*/("""


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
      <script type="text/javascript" src=""""),_display_(Seq[Any](/*22.44*/routes/*22.50*/.Application.javascriptRoutes())),format.raw/*22.81*/(""""></script>
      <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
      <link rel="stylesheet" type="text/css" href=""""),_display_(Seq[Any](/*24.53*/routes/*24.59*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*24.102*/("""">
      <script type="text/javascript" src=""""),_display_(Seq[Any](/*25.44*/routes/*25.50*/.Assets.at("js/jquery.chained.min.js"))),format.raw/*25.88*/("""" charset="utf-8"></script>
      <script type="text/javascript" src=""""),_display_(Seq[Any](/*26.44*/routes/*26.50*/.Application.javascriptRoutes())),format.raw/*26.81*/(""""></script>
   </head>
   
	<body>
   	<div class="clearfix ">
	<div class="input" margin:auto; floatwidth:70%; background-color:#b0e0e6;>
	<center>
	"""),_display_(Seq[Any](/*33.3*/{var str = "";
   	
   	if (email.format == "")
   		str += "<h1>Email Reporting stopped for</h1>";
   	else
   		str += "<h1>Email Reporting started for</h1>";
   	
 		str += "<br>";
   		
		str += "<h3 id='emailAddress'>"
		str += email.address;
		str += "</h3>";
		str += "<h3 id='emailFormat'>";
		str += email.format;
		str += "</h3>";
		Html(str);
  	})),format.raw/*49.5*/(""" 	
   <form id="addressForm" action="./sendemailnow" method="post">
 		<input type="hidden" id="address" name="address" value="email.address">
 		<input type="hidden" id="format" name="format" value="email.format">
   </form>
   
   """),_display_(Seq[Any](/*55.5*/{var str = "";
   	str = "<button type='button' class='btn primary' ";
   	if (email.format=="")
   		str += "onclick='home()'>Home";
   	else
   		str += "onclick='getEmailAddress()'>Send Email Now";
   	str += "</button>";
   	Html(str);
   })),format.raw/*63.5*/("""
   </center>
   
   <script>
   function home()	"""),format.raw/*67.20*/("""{"""),format.raw/*67.21*/("""
	   location.assign("/");
   """),format.raw/*69.4*/("""}"""),format.raw/*69.5*/("""
   function getEmailAddress()	"""),format.raw/*70.31*/("""{"""),format.raw/*70.32*/("""
	  var addr = $('#emailAddress').html();
	  $('#address').val(addr);
	  var fmt = $('#emailFormat').html();
	  $('#format').val(fmt);
	  var msg = "email address:" + $('#address').val() + "\n";
	  msg +=    "format       :" + $('#format').val(); 
	  alert(msg);
	  $('#addressForm').submit();
	  var debug;
   """),format.raw/*80.4*/("""}"""),format.raw/*80.5*/("""
   </script>
	</div>		
	</div>		
   	</body>
   	</html>
""")))})),format.raw/*86.2*/("""
"""))}
    }
    
    def render(email:Email): play.api.templates.Html = apply(email)
    
    def f:((Email) => play.api.templates.Html) = (email) => apply(email)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jan 17 09:59:50 EST 2014
                    SOURCE: C:/Users/dhallahan/workspace/regressionsiteRnd2-1/eclipse-regressionsite/app/views/displayEmailRecipientInfo.scala.html
                    HASH: 018733974a1bc13bf9cd0e00ed155f63d127b118
                    MATRIX: 742->1|832->14|873->21|893->33|932->35|1001->78|1028->79|1059->83|1087->84|1127->97|1155->98|1266->182|1294->183|1420->273|1435->279|1488->310|1686->472|1701->478|1767->521|1850->568|1865->574|1925->612|2033->684|2048->690|2101->721|2294->879|2689->1253|2964->1493|3237->1745|3318->1798|3347->1799|3406->1831|3434->1832|3494->1864|3523->1865|3871->2186|3899->2187|3995->2252
                    LINES: 26->1|29->1|32->4|32->4|32->4|37->9|37->9|39->11|39->11|41->13|41->13|46->18|46->18|50->22|50->22|50->22|52->24|52->24|52->24|53->25|53->25|53->25|54->26|54->26|54->26|61->33|77->49|83->55|91->63|95->67|95->67|97->69|97->69|98->70|98->70|108->80|108->80|114->86
                    -- GENERATED --
                */
            