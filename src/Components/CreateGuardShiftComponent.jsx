import React, { Component } from "react";
import GuardShiftService from '../service/GuardShiftService';


let today = new Date();

//const regExp1 = RegExp(/^[0-9]+$/);
const regExp2 = RegExp(/^[0-5]+$/);

const formValid = ({ isError, ...rest }) => {
    let valid = true;
  
    Object.values(isError).forEach((val) => {
      val.length > 0 && (valid = false);
    });
  
    Object.values(rest).forEach((val) => {
      val == null && (valid = false);
    });
  
    return valid;
  };

class CreateGuardShiftComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
        createdBy:"",
        modifiedBy:"",
        userId: "",
      name: "",
      time: "",
      date: "",
      isError: {
        userId: "",
        name: "",
        createdBy:"",
        modifiedBy:"",
      },
      disabled : true,
    };
    this.changeCreatedByHandler = this.changeCreatedByHandler.bind(this);
    this.changeModifiedByHandler = this.changeModifiedByHandler.bind(this);
    this.changeUserIdHandler = this.changeUserIdHandler.bind(this);
    this.changeNameHandler = this.changeNameHandler.bind(this);
    this.changeTimeHandler = this.changeTimeHandler.bind(this);
    this.changeDateHandler = this.changeDateHandler.bind(this);

    this.saveGuardShift = this.saveGuardShift.bind(this);
  }

  saveGuardShift = (e) => {
    e.preventDefault();
    if(formValid(this.state))
    {

    let guardShift = {
        createdBy: this.state.createdBy,
        modifiedBy: this.state.modifiedBy,
      userId: this.state.userId,
      name: this.state.name,
      time: this.state.time,
      date: today,
    };
    console.log("GuardShift => " + JSON.stringify(guardShift));

GuardShiftService.createGuardShift(guardShift).then((res) => {
      this.props.history.push("/GuardShift");
        alert("Form is Valid")

    });}
    else{
        alert("Form is Invalid")
    }

  };
  changeCreatedByHandler = (event) => {
    this.setState({ createdBy: event.target.value });
  };
  changeModifiedByHandler = (event) => {
    this.setState({ modifiedBy: event.target.value });
  };

  changeUserIdHandler = (event) => {
    this.setState({ userId: event.target.value });
  };

  changeNameHandler = (event) => {
    this.setState({ name: event.target.value });
  };

  changeTimeHandler = (event) => {
    this.setState({ time: event.target.value });
  };

  changeDateHandler = (event) => {
    this.setState({ today: event.target.value });
  };
  formValChange = (e) => {
    e.preventDefault();
    const { name, value } = e.target;
    let isError = { ...this.state.isError };
    switch (name) {
        case "createdBy":
        isError.createdBy =
          value.length < 5 ? "Atleast 5 characters required" : "";
        break;
      case "modifiedBy":
        isError.modifiedBy =
          value.length < 5 ? "Atleast 5 characters required" : "";
        break;
      case "userId":
        isError.userId = regExp2.test(value) ? "" : "Numeric Values Required";
        break;
      case "name":
        isError.name = value.length < 5 ? "Atleast 5 characters required" : "";
        break;
      
      default:
        break;
    }
    this.setState(
      {
        isError,
        [name]: value,
        disabled: false,
      },
      () => console.log(this.state)
    );
  };

  cancel() {
    this.props.history.push("/GuardShift");
  }
  render() {
    const { isError } = this.state;

    return (
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            <h3 className="text-center">Add Guard Shift</h3>
            <div className="card-body">
              <form>
              <div className="form-group">
                  <label>Created By</label>
                  <input
                    placeholder="createdBy"
                    name="createdBy"
                    className={
                      isError.createdBy.length > 0
                        ? "is-invalid form-control"
                        : "form-control"
                    }
                    value={this.state.createdBy}
                    noValidate
                    onChange={(this.changeCreatedByHandler, this.formValChange)}
                  />
                  {isError.createdBy.length > 0 && (
                    <span className="invalid-feedback">
                      {isError.createdBy}
                    </span>
                  )}
                </div>
                <div className="form-group">
                  <label>UserId</label>
                  <input
                    placeholder="User Id"
                    name="userId"
                    className={
                      isError.userId.length > 0
                        ? "is-invalid form-control"
                        : "form-control"
                    }
                    value={this.state.userId}
                    onChange={(this.changeUserIdHandler,this.formValChange)}
                  />
                  {isError.userId.length > 0 && (
                    <span className="invalid-feedback">{isError.userId}</span>
                  )}
                </div>
                <div className="form-group">
                  <label>Name</label>
                  <input
                    placeholder="Name"
                    name="name"
                    className={
                        isError.name.length > 0
                          ? "is-invalid form-control"
                          : "form-control"
                      }
                    value={this.state.name}
                    onChange={(this.changeNameHandler,this.formValChange)}
                  />
                  {isError.name.length > 0 && (
                    <span className="invalid-feedback">{isError.name}</span>
                  )}
                </div>
                <div className="form-group">
                  <label>Time </label>
                  <br></br>
                  <select  className="form-control"
                    name="time"
                    id="time"
                    value={this.state.time}
                    noValidate
                    onChange={this.changeTimeHandler}
                  >
                    <option value="9.00"> 9 am</option>
                    <option value="10.30">10.30 am</option>
                    <option value="11.30">11.30 am</option>
                    <option value="12.30">12.30 pm</option>
                    <option value="13.30">1.30 pm</option>
                    <option value="14.30">2.30 pm</option>
                    <option value="15.30">3.30 pm</option>
                    <option value="16.30">4.30 pm</option>
                    <option value="17.30">5.30 pm</option>
                    <option value="18.30">6.30 pm</option>
                  </select>
                </div>
                <div className="form-group">
                  <label>Date</label>
                  <input
                    placeholder="Date"
                    name="date"
                    className="form-control"
                    value={today}
                    onChange={this.changeDateHandler}
                  />
                </div>

                <button disabled={this.state.disabled}
                  className="btn btn-success"
                  onClick={this.saveGuardShift}
                >
                  Save
                </button>

                <button
                  className="btn btn-danger"
                  onClick={this.cancel.bind(this)}
                  style={{ marginLeft: "10px" }}
                >
                  Cancel
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default CreateGuardShiftComponent;
