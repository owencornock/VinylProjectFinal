`use strict`

import * as DOM from '../dom.js';

const writeItem = item => {
    const child = document.createElement(`li`);
    child.id = item._id;
    child.innerHTML = `${JSON.stringify(item)}`;
    DOM.listOutput.appendChild(child);
}
const put = (id) => {
    axios.put(`http://localhost:8080/replace/${id}`, {
        id: DOM.inputUpdateId.value,
        artist: DOM.inputUpdateArtist.value,
        album: DOM.inputUpdateAlbum.value,
        size: DOM.inputUpdateSize.value
    })
        .then((response) => {
            console.log(response);
        }).catch((err) => {
            console.log(err);
        });
}
DOM.buttonUpdate.onclick = () => put(DOM.inputUpdateId.value);