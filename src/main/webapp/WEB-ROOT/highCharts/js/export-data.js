"use strict";import Highcharts from"../parts/Globals.js";import U from"../parts/Utilities.js";var defined=U.defined,extend=U.extend,isObject=U.isObject;import"../parts/Chart.js";import"../mixins/ajax.js";import"../mixins/download-url.js";var pick=Highcharts.pick,win=Highcharts.win,doc=win.document,seriesTypes=Highcharts.seriesTypes,downloadURL=Highcharts.downloadURL,fireEvent=Highcharts.fireEvent;function htmlencode(t){return t.replace(/&/g,"&amp;").replace(/</g,"&lt;").replace(/>/g,"&gt;").replace(/"/g,"&quot;").replace(/'/g,"&#x27;").replace(/\//g,"&#x2F;")}function getBlobFromContent(t,e){var o=win.navigator,i=o.userAgent.indexOf("WebKit")>-1&&o.userAgent.indexOf("Chrome")<0,n=win.URL||win.webkitURL||win;try{if(o.msSaveOrOpenBlob&&win.MSBlobBuilder){var a=new win.MSBlobBuilder;return a.append(t),a.getBlob("image/svg+xml")}if(!i)return n.createObjectURL(new win.Blob(["\ufeff"+t],{type:e}))}catch(t){}}Highcharts.setOptions({exporting:{csv:{columnHeaderFormatter:null,dateFormat:"%Y-%m-%d %H:%M:%S",decimalPoint:null,itemDelimiter:null,lineDelimiter:"\n"},showTable:!1,useMultiLevelHeaders:!0,useRowspanHeaders:!0},lang:{downloadCSV:"Download CSV",downloadXLS:"Download XLS",openInCloud:"Open in Highcharts Cloud",viewData:"View data table"}}),Highcharts.addEvent(Highcharts.Chart,"render",function(){this.options&&this.options.exporting&&this.options.exporting.showTable&&!this.options.chart.forExport&&this.viewData()}),Highcharts.Chart.prototype.setUpKeyToAxis=function(){seriesTypes.arearange&&(seriesTypes.arearange.prototype.keyToAxis={low:"y",high:"y"}),seriesTypes.gantt&&(seriesTypes.gantt.prototype.keyToAxis={start:"x",end:"x"})},Highcharts.Chart.prototype.getDataRows=function(t){var e,o,i,n,a,r,s,l,p=this.hasParallelCoordinates,c=this.time,h=this.options.exporting&&this.options.exporting.csv||{},d=this.xAxis,m={},u=[],x=[],g=[],f=function(e,o,i){if(h.columnHeaderFormatter){var n=h.columnHeaderFormatter(e,o,i);if(!1!==n)return n}return e?e instanceof Highcharts.Axis?e.options.title&&e.options.title.text||(e.isDatetimeAxis?"DateTime":"Category"):t?{columnTitle:i>1?o:e.name,topLevelColumnTitle:e.name}:e.name+(i>1?" ("+o+")":""):"Category"},y=function(t,e,o){var i={},n={};return e.forEach(function(e){var a=(t.keyToAxis&&t.keyToAxis[e]||e)+"Axis",r=Highcharts.isNumber(o)?t.chart[a][o]:t[a];i[e]=r&&r.categories||[],n[e]=r&&r.isDatetimeAxis}),{categoryMap:i,dateTimeValueAxisMap:n}},b=[];for(a in n=0,this.setUpKeyToAxis(),this.series.forEach(function(e){var o,a,r=e.options.keys||e.pointArrayMap||["y"],s=r.length,l=!e.requireSorting&&{},u=d.indexOf(e.xAxis),v=y(e,r);if(!1!==e.options.includeInDataExport&&!e.options.isInternal&&!1!==e.visible){for(Highcharts.find(b,function(t){return t[0]===u})||b.push([u,n]),a=0;a<s;)i=f(e,r[a],r.length),g.push(i.columnTitle||i),t&&x.push(i.topLevelColumnTitle||i),a++;o={chart:e.chart,autoIncrement:e.autoIncrement,options:e.options,pointArrayMap:e.pointArrayMap},e.options.data.forEach(function(t,i){var d,x,g,f,b;for(p&&(v=y(e,r,i)),b={series:o},e.pointClass.prototype.applyOptions.apply(b,[t]),d=b.x,f=e.data[i]&&e.data[i].name,a=0,e.xAxis&&"name"!==e.exportKey||(d=f),l&&(l[d]&&(d+="|"+i),l[d]=!0),m[d]||(m[d]=[],m[d].xValues=[]),m[d].x=b.x,m[d].name=f,m[d].xValues[u]=b.x;a<s;)g=b[x=r[a]],m[d][n+a]=pick(v.categoryMap[x][g],v.dateTimeValueAxisMap[x]?c.dateFormat(h.dateFormat,g):null,g),a++}),n+=a}}),m)Object.hasOwnProperty.call(m,a)&&u.push(m[a]);for(o=t?[x,g]:[g],n=b.length;n--;)s=b[n][0],l=b[n][1],e=d[s],u.sort(function(t,e){return t.xValues[s]-e.xValues[s]}),r=f(e),o[0].splice(l,0,r),t&&o[1]&&o[1].splice(l,0,r),u.forEach(function(t){var o=t.name;e&&!defined(o)&&(e.isDatetimeAxis?(t.x instanceof Date&&(t.x=t.x.getTime()),o=c.dateFormat(h.dateFormat,t.x)):o=e.categories?pick(e.names[t.x],e.categories[t.x],t.x):t.x),t.splice(l,0,o)});return o=o.concat(u),fireEvent(this,"exportData",{dataRows:o}),o},Highcharts.Chart.prototype.getCSV=function(t){var e="",o=this.getDataRows(),i=this.options.exporting.csv,n=pick(i.decimalPoint,","!==i.itemDelimiter&&t?1.1.toLocaleString()[1]:"."),a=pick(i.itemDelimiter,","===n?";":","),r=i.lineDelimiter;return o.forEach(function(t,i){for(var s="",l=t.length;l--;)"string"==typeof(s=t[l])&&(s='"'+s+'"'),"number"==typeof s&&"."!==n&&(s=s.toString().replace(".",n)),t[l]=s;e+=t.join(a),i<o.length-1&&(e+=r)}),e},Highcharts.Chart.prototype.getTable=function(t){var e='<table id="highcharts-data-table-'+this.index+'">',o=this.options,i=t?1.1.toLocaleString()[1]:".",n=pick(o.exporting.useMultiLevelHeaders,!0),a=this.getDataRows(n),r=0,s=n?a.shift():null,l=a.shift(),p=function(t,e,o,n){var a=pick(n,""),r="text"+(e?" "+e:"");return"number"==typeof a?(a=a.toString(),","===i&&(a=a.replace(".",i)),r="number"):n||(r="empty"),"<"+t+(o?" "+o:"")+' class="'+r+'">'+a+"</"+t+">"};!1!==o.exporting.tableCaption&&(e+='<caption class="highcharts-table-caption">'+pick(o.exporting.tableCaption,o.title.text?htmlencode(o.title.text):"Chart")+"</caption>");for(var c=0,h=a.length;c<h;++c)a[c].length>r&&(r=a[c].length);e+=function(t,e,i){var a,r,s="<thead>",l=0,c=i||e&&e.length,h=0;if(n&&t&&e&&!function(t,e){var o=t.length;if(e.length!==o)return!1;for(;o--;)if(t[o]!==e[o])return!1;return!0}(t,e)){for(s+="<tr>";l<c;++l)(a=t[l])===t[l+1]?++h:h?(s+=p("th","highcharts-table-topheading",'scope="col" colspan="'+(h+1)+'"',a),h=0):(a===e[l]?o.exporting.useRowspanHeaders?(r=2,delete e[l]):(r=1,e[l]=""):r=1,s+=p("th","highcharts-table-topheading",'scope="col"'+(r>1?' valign="top" rowspan="'+r+'"':""),a));s+="</tr>"}if(e){for(s+="<tr>",l=0,c=e.length;l<c;++l)void 0!==e[l]&&(s+=p("th",null,'scope="col"',e[l]));s+="</tr>"}return s+="</thead>"}(s,l,Math.max(r,l.length)),e+="<tbody>",a.forEach(function(t){e+="<tr>";for(var o=0;o<r;o++)e+=p(o?"td":"th",null,o?"":'scope="row"',t[o]);e+="</tr>"});var d={html:e+="</tbody></table>"};return fireEvent(this,"afterGetTable",d),d.html},Highcharts.Chart.prototype.downloadCSV=function(){var t=this.getCSV(!0);downloadURL(getBlobFromContent(t,"text/csv")||"data:text/csv,\ufeff"+encodeURIComponent(t),this.getFilename()+".csv")},Highcharts.Chart.prototype.downloadXLS=function(){var t,e='<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head>\x3c!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>Ark1</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--\x3e<style>td{border:none;font-family: Calibri, sans-serif;} .number{mso-number-format:"0.00";} .text{ mso-number-format:"@";}</style><meta name=ProgId content=Excel.Sheet><meta charset=UTF-8></head><body>'+this.getTable(!0)+"</body></html>";downloadURL(getBlobFromContent(e,"application/vnd.ms-excel")||"data:application/vnd.ms-excel;base64,"+(t=e,win.btoa(unescape(encodeURIComponent(t)))),this.getFilename()+".xls")},Highcharts.Chart.prototype.viewData=function(){this.dataTableDiv||(this.dataTableDiv=doc.createElement("div"),this.dataTableDiv.className="highcharts-data-table",this.renderTo.parentNode.insertBefore(this.dataTableDiv,this.renderTo.nextSibling)),this.dataTableDiv.innerHTML=this.getTable(),fireEvent(this,"afterViewData",this.dataTableDiv)},Highcharts.Chart.prototype.openInCloud=function(){var t,e,o;(function t(e){Object.keys(e).forEach(function(o){"function"==typeof e[o]&&delete e[o],isObject(e[o])&&t(e[o])})})(t=Highcharts.merge(this.userOptions)),e={name:t.title&&t.title.text||"Chart title",options:t,settings:{constructor:"Chart",dataProvider:{csv:this.getCSV()}}},o=JSON.stringify(e),function(){var t=doc.createElement("form");doc.body.appendChild(t),t.method="post",t.action="https://cloud-api.highcharts.com/openincloud",t.target="_blank";var e=doc.createElement("input");e.type="hidden",e.name="chart",e.value=o,t.appendChild(e),t.submit(),doc.body.removeChild(t)}()};var exportingOptions=Highcharts.getOptions().exporting;exportingOptions&&(extend(exportingOptions.menuItemDefinitions,{downloadCSV:{textKey:"downloadCSV",onclick:function(){this.downloadCSV()}},downloadXLS:{textKey:"downloadXLS",onclick:function(){this.downloadXLS()}},viewData:{textKey:"viewData",onclick:function(){this.viewData()}},openInCloud:{textKey:"openInCloud",onclick:function(){this.openInCloud()}}}),exportingOptions.buttons&&exportingOptions.buttons.contextButton.menuItems.push("separator","downloadCSV","downloadXLS","viewData","openInCloud")),seriesTypes.map&&(seriesTypes.map.prototype.exportKey="name"),seriesTypes.mapbubble&&(seriesTypes.mapbubble.prototype.exportKey="name"),seriesTypes.treemap&&(seriesTypes.treemap.prototype.exportKey="name");