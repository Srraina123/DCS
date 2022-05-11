import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

@WebService(serviceName = &quot;Calculator&quot;)
@Stateless()
public class Calculator {
int k;
@WebMethod (operationName=&quot;add&quot;)
public int add(@WebParam(name=&quot;a&quot;)int a,@WebParam(name = &quot;b&quot;)int b){
k=a+b;
return k;
}

b){
@WebMethod (operationName=&quot;subtract&quot;)
public int subtract(@WebParam(name=&quot;a&quot;)int a,@WebParam(name = &quot;b&quot;)int
k=a-b;
return k;
}
@WebMethod (operationName=&quot;multiply&quot;)
public int multiply(@WebParam(name=&quot;a&quot;)int a,@WebParam(name = &quot;b&quot;)int
b){
k=a*b;
return k;

@WebMethod (operationName=&quot;divide&quot;)
public int divide(@WebParam(name=&quot;a&quot;)int a,@WebParam(name = &quot;b&quot;)int b){
k=(a/b);
return k;
}
}

@GET
@Path(&quot;/add/{a},{b},{opt}&quot;)
public int add(@PathParam(&quot;a&quot;) int a,@PathParam(&quot;b&quot;) int
b,@PathParam(&quot;opt&quot;) String opt)
{
if(opt.equals(&quot;+&quot;))
return a+b;
else
return 0;
}

@GET
@Path(&quot;/sub/{a},{b},{opt}&quot;)
public int sub(@PathParam(&quot;a&quot;) int a,@PathParam(&quot;b&quot;) int
b,@PathParam(&quot;opt&quot;) String opt)
{
if(opt.equals(&quot;-&quot;))
return a-b;
else
return 0;
}

@POST
@Path(&quot;/mul&quot;)
public int mul(@FormParam(&quot;a&quot;) int a,@FormParam(&quot;b&quot;) int
b,@FormParam(&quot;opt&quot;) String opt)
{

}
if(opt.equals(&quot;*&quot;))
return a*b;
else
return 0;
}

@POST
@Path(&quot;/div&quot;)
public int div(@FormParam(&quot;a&quot;) int a,@FormParam(&quot;b&quot;) int
b,@FormParam(&quot;opt&quot;) String opt)
{
if(opt.equals(&quot;/&quot;))
return a/b;
else
return 0;
}

@POST
@Path(&quot;/calculator_Post&quot;)
public int calculator_Post(@FormParam(&quot;a&quot;) int a,@FormParam(&quot;b&quot;) int
b,@FormParam(&quot;opt&quot;) String opt)
{
if(opt.equals(&quot;#&quot;))
return a+b;
else if(opt.equals(&quot;-&quot;))
return a-b;
else if(opt.equals(&quot;*&quot;))
return a*b;
else if(opt.equals(&quot;/&quot;))
return a/b;
else
return 0;

@GET
@Path(&quot;/calget/{a},{b},{opt}&quot;)
public float calget(@PathParam(&quot;a&quot;) int a,@PathParam(&quot;b&quot;) int
b,@PathParam(&quot;opt&quot;) String opt)
{
if(opt.equals(&quot;+&quot;))
return a+b;
else if(opt.equals(&quot;-&quot;))
return a-b;
else if(opt.equals(&quot;*&quot;))
return a*b;
else if(opt.equals(&quot;!&quot;))
return (a/b);
else
return 0;
}
