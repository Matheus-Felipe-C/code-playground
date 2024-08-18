const lists = document.getElementsByTagName('ul')

for (let i = 0; i < lists.length; i++) {
    const list = lists[i];
    const items = list.getElementsByTagName('li');

    const countParagraph = document.createElement('p');
    countParagraph.textContent = `Os ${items.length} elementos 'li' da lista ${i+1}`;
    document.body.appendChild(countParagraph);

    const textParagraph = document.createElement('p');
    textParagraph.textContent = "Texto dentro dos elementos li:";
    document.body.appendChild(textParagraph);

    for (let j = 0; j < items.length; j++) {
        document.write("<p>" + items[j].innerHTML + "</p>");
    }
}
