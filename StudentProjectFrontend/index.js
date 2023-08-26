function sub(event)
{
    event.preventDefault();

    let form = document.getElementById("form");
    let formdata = new FormData(form);
      
    
    let obj ={};
    for( let x of formdata)
    {
        obj[x[0]]=x[1];
    }
    console.log(obj);

    let h= new Headers()
   h.set("Content-Type","application/json");
    fetch("http://localhost:8080/messege",{
        method:"POST",body:JSON.stringify(obj),headers:h
    })


    
}

function get(event)
{
    event.preventDefault();
    
    const itemTableBody = document.getElementById('itemTableBody');

    // Fetch data from the API
    fetch("http://localhost:8080/get")
        .then(response => response.json())
        .then(items => {
            // Populate the table with fetched data
            items.forEach(item => {
                const row = document.createElement('tr');
                row.innerHTML = `
                <td>${item.id}</td>
                <td>${item.firstName}</td>
                <td>${item.lastName}</td>
                <td>${item.email}</td>
                `;
                itemTableBody.appendChild(row);
            });
            items.clear();
        })
        

}