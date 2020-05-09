import React from 'react';

import logo from './book.svg';
import Books from "./book/Books.jsx";
import CreateBook from "./book/CreateBook";
import './App.css';

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";
import BestsellerBooks from "./book/BestsellerBooks";

//  netstat -ano | findstr :3000
// 	taskkill /PID XYZ /F

function App() {
  return (
      <div className="App">
          <Router>
              <header className="App-header">
                  <h1>Home</h1>
                  <img src={logo} className="App-logo" alt="logo" />
                  <p>Welcome to our book store</p>
                  <nav><Link to={"/"}>Home</Link> | <Link to={"/books"}>Books</Link> | <Link to={"/create"}>Create Book</Link> | <Link to={"/nytimesbestseller"}>NYTimesBestsellers</Link> </nav>
              </header>

              <Switch>
                  <Route path={"/books"}>
                      <Books />
                  </Route>

                  <Route path={"/create"}>
                      <CreateBook />
                  </Route>

                  <Route path={"/nytimesbestseller"}>
                      <BestsellerBooks />
                  </Route>


                  <Route path={"/"}>
                      <p className="homeInfo">Welcome to our Book store.</p>
                      <p className="homeInfo">You can view pre-added books or add your own.</p>
                  </Route>
              </Switch>

              <footer className="App-footer">
                  <p>Benjamin Gut</p>
              </footer>
          </Router>
      </div>
  );
}


export default App;
