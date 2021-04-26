import React, { Component } from "react";
import FlatService from "../services/FlatService";



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

class CreateFlatComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            
            createdBy: '',
            modifiedBy: '',
            ownerName: '',
            flatNo: '',
            floorNo: '',
            flatType: '',
            isError: {
                createdBy: '',
                modifiedBy: '',
                ownerName: "",
                flatNo: "",
                floorNo: "",
                flatType: "",
              },
              disabled: true,
        }
        
        this.changeCreatedByHandler = this.changeCreatedByHandler.bind(this);
        this.changeModifiedByHandler = this.changeModifiedByHandler.bind(this);
        this.changeownerNameHandler = this.changeownerNameHandler.bind(this);
        this.changeflatNoHandler = this.changeflatNoHandler.bind(this);
        this.changefloorNoHandler = this.changefloorNoHandler.bind(this);
        this.changeflatTypeHandler = this.changeflatTypeHandler.bind(this);
        this.saveFlat = this.saveFlat.bind(this);
    }
    saveFlat = (e) => {
        e.preventDefault();
        if(formValid(this.state))
        {
        let flat = {createdBy: this.state.createdBy,
            modifiedBy: this.state.modifiedBy, ownerName: this.state.ownerName, flatNo: this.state.flatNo, floorNo: this.state.floorNo, flatType: this.state.flatType };
        console.log('flat => ' + JSON.stringify(flat));
            FlatService.createFlat(flat).then(res => {
                this.props.history.push('');
                alert("Form is Valid")
            });}
            else{
                alert("Form is Invalid")
            }
    }
    changeCreatedByHandler = (event) => {
        this.setState({ createdBy: event.target.value });
      };
      changeModifiedByHandler = (event) => {
        this.setState({ modifiedBy: event.target.value });
      };
    changeownerNameHandler = (event) => {
        this.setState({ ownerName: event.target.value });
    };

    changeflatNoHandler = (event) => {
        this.setState({ flatNo: event.target.value });
    };
    changefloorNoHandler = (event) => {
        this.setState({ floorNo: event.target.value });
    };
    changeflatTypeHandler = (event) => {
        this.setState({ flatType: event.target.value });
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
          case "ownerName":
            isError.ownerName = value.length < 5 ? "Atleast 5 character required " : "";
            break;
          case "flatNo":
            isError.flatNo = value.length < 4 ? "Flat No is Invalid" : "";
            break;
          case "floorNo":
            isError.floorNo = regExp2.test(value) ? "" : "Floor No is Invalid";
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
        this.props.history.push('');
    }

    render() {
        const { isError } = this.state;

        return (
            <div>
                <br></br>
                <div className="container" >
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3"> 
                        <h3 className="text-center">Add Flat</h3>
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
                                        <label> Owner Name: </label>
                                        <input placeholder="Owner Name" name="ownerName"
                                        className={
                                        isError.ownerName.length > 0
                                            ? "is-invalid form-control"
                                            : "form-control"
                                        }
                                            value={this.state.ownerName} onChange={(this.changeownerNameHandler, this.formValChange)} />
                                            {isError.ownerName.length > 0 && (
                    <span className="invalid-feedback">{isError.ownerName}</span>
                  )}
                                    </div>
                                    <div className="form-group">
                                        <label> flatNo: </label>
                                        <input placeholder="flatNo" name="flatNo" 
                                        className={
                                            isError.flatNo.length > 0
                                              ? "is-invalid form-control"
                                              : "form-control"
                                          }
                                            value={this.state.flatNo} onChange={(this.changeflatNoHandler, this.formValChange)} />
                                            {isError.flatNo.length > 0 && (
                    <span className="invalid-feedback">{isError.flatNo}</span>
                  )}
                                    </div>
                                    <div className="form-group">
                                        <label> floorNo: </label>
                                        <input placeholder="floorNo" name="floorNo"
                                        className={
                                            isError.floorNo.length > 0
                                              ? "is-invalid form-control"
                                              : "form-control"
                                          }
                                            value={this.state.floorNo} onChange={(this.changefloorNoHandler, this.formValChange)} />
                                            {isError.floorNo.length > 0 && (
                    <span className="invalid-feedback">{isError.floorNo}</span>
                  )}
                                    </div>
                                    <div className="form-group">
                  <label>Flat Type </label>
                  <br></br>
                  <select className="form-control"
                    name="flatType"
                    id="flatType"
                    value={this.state.flatType}
                    noValidate
                    onChange={this.changeflatTypeHandler}
                  >
                    <option value="2BHK">2BHK</option>
                    <option value="3BHK">3BHK</option>
                    <option value="4BHK">4BHK</option>
                    <option value="No bedroom">No bedroom</option>
                    
                  </select>
                </div>

                                    <button disabled={this.state.disabled} className="btn btn-success" onClick={this.saveFlat}>Save</button>
                                    <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{ marginLeft: "10px" }}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}
export default CreateFlatComponent;
