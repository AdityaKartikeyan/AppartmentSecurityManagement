import React, { Component } from "react";
import GuardShiftService from "../service/GuardShiftService";


class ListGuardShiftComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      guardShift: [],
    };

    this.addGuardShift = this.addGuardShift.bind(this);
    this.editGuardShift = this.editGuardShift.bind(this);
    this.deleteGuardShift = this.deleteGuardShift.bind(this);
  }
  baseEntity(userId) {
    this.props.history.push(`/getByPk/${userId}`);
  }
  editGuardShift(userId) {
    this.props.history.push(`/update-GuardShift/${userId}`);
  }
  componentDidMount() {
    GuardShiftService.getGuardShift().then((res) => {
      this.setState({ guardShift: res.data });
    });
  }

  addGuardShift() {
    this.props.history.push("/add-GuardShift");
  }

  viewGuardShift(userId) {
    this.props.history.push(`/getById/${userId}`);
  }
  deleteGuardShift(id) {
    GuardShiftService.deleteGuardShift(id).then((res) => {
      this.setState({
        guardShift: this.state.guardShift.filter(
          (guardShift) => guardShift.id !== id
        ),
      });
    });
  }
  
  render() {
    return (
      <div>
        <h2 className="text-center">GuardShift List</h2>
        <div className="row">
          <button className="btn btn-primary" onClick={this.addGuardShift}>
            Add Guard Shift
          </button>
        </div>
        <div className="row">
          <table className="table table-striped table-bordered">
            <thead>
              <tr>
                <th>Name</th>
                <th>Time</th>
                <th>Date</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {this.state.guardShift.map((guardShift) => (
                <tr key={guardShift.userId}>
                  <td>{guardShift.name}</td>
                  <td>{guardShift.time}</td>
                  <td>{guardShift.date}</td>
                  <td>
                    <button
                      onClick={() =>
                        this.editGuardShift(guardShift.userId)
                      }
                      className="btn btn-info"
                    >
                      Update
                    </button>
                    <button
                      style={{ marginLeft: "10px" }}
                      onClick={() => this.deleteGuardShift(guardShift.id)}
                      className="btn btn-danger"
                    >
                      Delete
                    </button>
                    <button
                      style={{ marginLeft: "10px" }}
                      onClick={() =>
                        this.viewGuardShift(guardShift.userId)
                      }
                      className="btn btn-info"
                    >
                      View
                    </button>
                    <button
                      style={{ marginLeft: "10px" }}
                      onClick={() => this.baseEntity(guardShift.userId)}
                      className="btn btn-info"
                    >
                      Audit
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default ListGuardShiftComponent;
