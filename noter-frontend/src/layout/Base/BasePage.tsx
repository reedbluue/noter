import {Outlet} from "react-router-dom";
import {Toaster} from "react-hot-toast";

export const BasePage = () => {
  return (
      <div className={"h-screen w-screen flex flex-col"}>
        <Outlet/>
        <Toaster position={"bottom-left"}/>
      </div>
  );
}