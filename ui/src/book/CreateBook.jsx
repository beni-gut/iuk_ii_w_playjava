import React from 'react';
import Book from "./Book.jsx";
import "./CreateBook.css";

class CreateBook extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            title: "",
            author: "",
            isbn13: "",
            isbn10: "",
            description: "",
            publisher: "",
            pages: ""
        };
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event) {
        if(!(this.testForEmpty())) {

            fetch("api/books", {
                method: "POST",
                body: JSON.stringify(this.state),
                headers: {
                    "Content-Type": "application/json"
                }
            })
                .then(response => {
                    if (response.status !== 200) {
                        console.log("Looks like there was a problem. Status Code: \n" + response.status)
                        console.log(response.statusText)
                    } else {
                        const json = response.json();
                        console.log(json);
                    }
                })
        } else {
            //Mal schauen was ich hier noch mache
            console.log("There are empty fields")
        }

        event.preventDefault();
    }

    //Das geht sicher besser...
    testForEmpty() {
        let index = ["title", "isbn13", "isbn10", "description", "publisher", "pages"];
        let values = index.map(el => this.state[el]);
        let test = values.includes("");
        return test;
    }

    handleInputChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;

        this.setState({
            [name]: value
        });
    }

    render() {
        return (
            <div className={"container"}>
                <form onSubmit={this.handleSubmit}>
                    <label className={"formLabel"}>
                        Title:
                        <input type="text" name="title" className={"formField"}
                               value={this.state.title}
                               onChange={this.handleInputChange}
                        />
                    </label>
                    <br />
                    <label className={"formLabel"}>
                        Author:
                        <input type="text" name="author" className={"formField"}
                               value={this.state.author}
                               onChange={this.handleInputChange}
                        />
                    </label>
                    <br />
                    <label className={"formLabel"} >
                        Description:
                        <textarea name="description" className={"formField formTextField"}
                                  value={this.state.description}
                               onChange={this.handleInputChange}
                        />
                    </label>
                    <br />
                    <label className={"formLabel"}>
                        ISBN13:
                        <input type="text" name="isbn13" className={"formField"}
                               value={this.state.isbn13}
                               onChange={this.handleInputChange}
                        />
                    </label>
                    <br />
                    <label className={"formLabel"}>
                        ISBN10:
                        <input type="text" name="isbn10" className={"formField"}
                               value={this.state.isbn10}
                               onChange={this.handleInputChange}
                        />
                    </label>
                    <br />
                    <label className={"formLabel"}>
                        Publisher:
                        <input type="text" name="publisher" className={"formField"}
                               value={this.state.publisher}
                               onChange={this.handleInputChange}
                        />
                    </label>
                    <br />
                    <label className={"formLabel"}>
                        Number of pages:
                        <input type="number" name="pages" className={"formField"}
                               value={this.state.pages}
                               onChange={this.handleInputChange}
                        />
                    </label>
                    <br />
                    <input id="submitButton" type="submit" value="Create Book"/>
                </form>
            </div>
        );
    }
}


export default CreateBook;
