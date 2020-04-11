import React from 'react';
import {
  BrowserRouter as Router,
      Switch,
      Route,
      Link,
      useRouteMatch,
      useParams
} from "react-router-dom";
import logo from './logo.svg';
import './App.css';

function App() {
  return (
      <Router>
          <div>
              <nav className={"navbar"}>
                  <ul>
                      <li className={"App-Link"}>
                          <Link to={"/"}>Home</Link>
                      </li>
                      <li>
                          <Link to={"/about"}>About</Link>
                      </li>
                      <li>
                          <Link to={"/topics"}>Topics</Link>
                      </li>
                  </ul>
              </nav>

              {/* A <Switch> looks through its children <Route>s and
                renders the first one that matches the current URL. */}
              <Switch>
                  <Route path={"/about"}>
                      <About />
                  </Route>
                  <Route path={"/topics"}>
                      <Topics />
                  </Route>
                  <Route path={"/"}>
                      <Home />
                  </Route>
              </Switch>
          </div>
      </Router>);
}

function Home() {
  return (
      <div className="App">
          <header className="App-header">
              <h1>Home</h1>
              <img src={logo} className="App-logo" alt="logo" />
              <p>
                  Edit <code>src/App.js</code> and save to reload.
              </p>
              <a
                  className="App-link"
                  href="https://reactjs.org"
                  target="_blank"
                  rel="noopener noreferrer"
              >
                  Learn React
              </a>
              <h1>Test, does it reload when i just type something</h1>
              <p>Incredible</p>
              <p>Tralala</p>
        </header>
      </div>
  );
}

function About() {
  return <h2>About</h2>;
}

function Topics() {
  let match = useRouteMatch();

  return (
      <div>
          <h2>Topics</h2>

          <ul>
              <li>
                <Link to={'${match.url}/components'}>Components</Link>
              </li>
              <li>
                <Link to={'${match.url}/props-v-state'}>
                  Props v. State
                </Link>
              </li>
          </ul>

          {/* The Topics page has its own <Switch> with more routes
            that build on the /topics URL path. You can think of the
            2nd <Route> here as an "index" page for all topics, or
            the page that is shown when no topic is selected */}
              <Switch>
                  <Route path={`${match.path}/:topicId`}>
                      <Topic />
                  </Route>
                  <Route path={match.path}>
                      <h3>Please select a topic.</h3>
                  </Route>
              </Switch>
      </div>
  )
}

function Topic() {
  let { topicId } = useParams();
  return <h3>Requested topic ID: {topicId}</h3>;
}



export default App;
