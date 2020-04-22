import React from 'react';
import Book from "./Book.jsx";
import "./CreateBook.css";

class CreateBook extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            title: "",
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
        alert("Create book with title " + this.state.title + "..." + " implement fetch POST")
        event.preventDefault();
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
            <div>
                <form onSubmit={this.handleSubmit}>
                    <label class="formLabel">
                        Title:
                        <input type="text" name="title" class="formField" value={this.state.title}
                               onChange={this.handleInputChange}
                        />
                    </label>
                    <br />
                    <label class="formLabel">
                        Description:
                        <textarea name="description" class="formField formTextField" value={this.state.description}
                               onChange={this.handleInputChange}
                        />
                    </label>
                    <br />
                    <label class="formLabel">
                        ISBN13:
                        <input type="text" name="isbn13" class="formField" value={this.state.isbn13}
                               onChange={this.handleInputChange}
                        />
                    </label>
                    <br />
                    <label class="formLabel">
                        ISBN10:
                        <input type="text" name="isbn10" class="formField" value={this.state.isbn10}
                               onChange={this.handleInputChange}
                        />
                    </label>
                    <br />
                    <label class="formLabel">
                        Publisher:
                        <input type="text" name="publisher" class="formField" value={this.state.publisher}
                               onChange={this.handleInputChange}
                        />
                    </label>
                    <br />
                    <label class="formLabel">
                        Number of pages:
                        <input type="number" name="title" class="formField" value={this.state.pages}
                               onChange={this.handleInputChange}
                        />
                    </label>
                    <br />
                    <input type="submit" value="Create Book"/>
                </form>
            </div>
        );
    }
}


export default CreateBook;
