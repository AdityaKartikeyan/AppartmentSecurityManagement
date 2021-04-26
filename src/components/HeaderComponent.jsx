import React, { Component } from "react";

class HeaderComponent extends Component {
  render() {
    return (
      <div className="menu-bar">
        <header className="header">
          <nav className="navbar navbar-expand-lg navbar-light">
            <div>
              <a href="http://localhost:3000/" className="navbar-brand">
                Apartment Security Management
              </a>
            </div>

            <button
              className="navbar-toggler"
              type="button"
              data-toggle="collapse"
              data-target="#navbarNav"
              aria-controls="navbarNav"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <i className="fas fa-bars"></i>
            </button>
            <div className="collapse navbar-collapse" id="navbarNav">
              <ul className="navbar-nav ml-auto">
                <li className="nav-item">
                  <a className="nav-link" href="/employees">
                    <strong>Employee</strong>
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link" href="/requirements">
                    <strong>Requirement</strong>
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link" href="/offers">
                    <strong>Offer</strong>
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link" href="/resources">
                    <strong>Resources</strong>
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link" href="/proposal">
                    <strong>Proposal</strong>
                  </a>
                </li>
              </ul>
            </div>
          </nav>
        </header>
      </div>
    );
  }
}

export default HeaderComponent;
