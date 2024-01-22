export type OptionCardProps = {
    topic: Topic
}

export type Topic = {
    id: string,
    title: string,
    icon: string,
    category: string
}

export type StartPageType = {
    topics: Topic[]
}
