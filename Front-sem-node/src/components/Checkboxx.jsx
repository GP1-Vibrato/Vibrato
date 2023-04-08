import React from "react";
import "../Styles/checkbox.css";

const Checkboxx = ({ label, checked, onChange }) => {
  return (
    <label className="checkbox">
      <input type="checkbox" checked={checked} onChange={onChange} />
      <span className="checkmark"></span>
      <span className="label">{label}</span>
    </label>
  );
};

export default Checkboxx;