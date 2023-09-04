const adminReportContainer = document.getElementById("j-admin-report-container");

const adminCom = document.getElementById("j-admin-com");

function reportBtn(){

    if(adminReportContainer.style.display !== 'none'){
        adminReportContainer.style.display = 'none';
        adminReportContainer.style.backgroundColor = '#eee';

        
    }else{
        adminReportContainer.style.display = 'block';
    }
    


}

function adminCommunity(){

    if(adminCom.style.display !== 'none'){
        adminCom.style.display = 'none';
        adminCom.style.transition = '1s';
        adminCom.style.backgroundColor = '#eee';
    }else{
        adminCom.style.display = 'block';
    }


}

