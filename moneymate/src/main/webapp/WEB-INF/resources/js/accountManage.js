$(".hover").mouseleave(
    function() {
      $(this).removeClass("hover");
    }
  );


$("#new").click(function(){

  $("#modal").css("display", "block");
  $("#main").sytle("backgroundColor", "rgba(0, 0, 0, 0.5)");

})