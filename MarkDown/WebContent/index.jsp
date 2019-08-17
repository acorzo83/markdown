<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<!-- Boostrap Framework Ver: 4_3_1 -->
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="js/bootstrap_4_3_1/css/bootstrap.min.css"/>
	
 	<!-- Boostrap Scripts -->
	<script type="text/javascript" src="js/jquery_3_4_0/jquery-3.4.0.min.js"></script>
	<script type="text/javascript" src="js/popper/popper.min.js"></script>
	<script type="text/javascript" src="js/bootstrap_4_3_1/js/bootstrap.min.js"></script>
	
	<!--  CSS - JQuery Confirm -->
    <link rel="stylesheet" href="./css/JQueryMobile_Confirm/jquery-confirm.css">
	
	<!-- Scripts - JQuery Confirm -->
	<script src="./js/JQueryMobile_Confirm_3_3_0/jquery-confirm.js"></script>
	
 	<link rel="stylesheet" href="./css/markdown.css" crossorigin="anonymous">
    <script src="./js/markdown.js" crossorigin="anonymous"></script>
</head>
<body>
	<div class="MDBody">
	    <div class="MDBBody-Documents">
	        <div class="MDBBody-Documents-Title">
	        	<div class="MDBBody-Documents-Title-Position">
	        		<span class="oFontTitleApp">MarkDownEditor</span>
	        	</div>
	        </div>
	        <div id="MDBBody-Documents-Files" class="MDBBody-Documents-Files">
	        	
	        </div>
	    </div>
	    <div class="MDBody-Editor">
	    	<div class="oTextAreEditorControls">
	    		<div class="oTextAreEditorControls-Buttons">
	    			<button id="oBtnNuevo">Nuevo</button>
	    		</div>
	    		<div class="oTextAreEditorControls-Buttons">
	    			<button id="oBtnEditar">Guardar</button>
	    		</div>
	    		<div class="oTextAreEditorControls-Buttons">
	    			<button id="oBtnGuardar">Guardar</button>
	    		</div>
	    		<div class="oTextAreEditorControls-Buttons">
	    			<button id="oBtnEliminar">Eliminar</button>
	    		</div>
	    		<div class="oTextAreEditorControls-Buttons">
	    			<button id="oBtnCancelar">Cancelar</button>
	    		</div>
	    	</div>
	        <textarea id="oTextEditor" class="oTextAreaEditor" cols="100"></textarea>
	    </div>
	    <div id="oTextPreview" class="MDBBody-Preview">
	    </div>
	</div>
</body>
</html>