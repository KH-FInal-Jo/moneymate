$(".hover").mouseleave(
    function() {
      $(this).removeClass("hover");
    }
  );


$("#new").click(function(){

  // console.log(11111);

  $("#modal").css("display", "block");
  $("#main-container").css("backgroundColor", "rgba(0, 0, 0, 0.5)");
  $("#new").css("z-index", "auto");

})

