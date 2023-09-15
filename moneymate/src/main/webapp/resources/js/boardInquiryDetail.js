const updateBtn= document.getElementById("updateBtn");
const deleteBtn= document.getElementById("deleteBtn");
const goToList= document.getElementById("goToList");


updateBtn.addEventListener("click", ()=>{

    location.href 
        = location.pathname + "/update" + location.search
    
})