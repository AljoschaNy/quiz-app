import "./MainContent.css";
import OptionCard from "./OptionCard.tsx";
import {Topic} from "../../types/types.ts";

function MainContent() {

    const topicsArray:Topic[] = [
        {id: "1", name:"HTML",path:"./src/assets/icon-html.svg"},
        {id: "2", name:"CSS", path:"./src/assets/icon-css.svg"},
        {id: "3", name:"Javascript", path:"./src/assets/icon-js.svg"},
        {id: "4", name:"Accessibility", path:"./src/assets/icon-accessibility.svg"}
    ];

    return (
        <main className={"main-content"}>
            <section className={"info-section"}>
                <h1><span className={"intro-text"}>Welcome to the</span> Frontend Quiz!</h1>
                <aside>Pick a subject to get started.</aside>
            </section>

            <section className={"options-container"}>
                {topicsArray.map(topic => {
                    return <OptionCard key={topic.id} topic={topic}/>;
                })}
            </section>

        </main>
    );
}

export default MainContent;
