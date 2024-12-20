function showContent(id) {
    var contents = document.getElementsByClassName('content');
    for (var i = 0; i < contents.length; i++) {
        contents[i].style.display = 'none';
    }
    document.getElementById(id).style.display = 'block';
}

function loadContent(page) { 
    fetch(page) 
        .then(response => response.text())
        .then(data => { 
            document.getElementById('content').innerHTML = data; 
        }) 
        .catch(error => console.error('Error loading the content:', error)); 
    }