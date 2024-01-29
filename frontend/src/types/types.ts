export type TopicCardProps = {
    topic: Topic
}

export type OptionCardProps = {
    optionCount: string,
    optionText: string,
    onClick: () => void
    isSelected: boolean
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

export type Question = {
    id: string,
    query: string,
    options: string[],
    answer: string
}
